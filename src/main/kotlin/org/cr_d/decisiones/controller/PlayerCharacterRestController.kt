package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.CharacterResponse
import org.cr_d.decisiones.dto.PlayerCharacterRequest
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.PlayerCharacterService
import org.cr_d.decisiones.usecases.CreateCharacterUseCase
import org.cr_d.decisiones.usecases.GetCharacterByUsernameUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/characters")
class PlayerCharacterRestController (
    private val characterService: PlayerCharacterService,
    private val create: CreateCharacterUseCase,
    private val getByUser: GetCharacterByUsernameUseCase
) {
    @GetMapping("")
    fun findAll(): List<CharacterResponse> {
        val characters = characterService.getAllCharacters().map{ it.toResponse() }

        return characters;
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id : Long): CharacterResponse? {
        val character = characterService.getCharacterById(id)
        if(character != null) return character.toResponse()

        return null
    }

    @GetMapping("/by-user/{userId}")
    fun findByUsername(@PathVariable("userId") userId : Long) : List<CharacterResponse>? {
        return getByUser.execute(userId).map{ it.toResponse() }
    }

    @PostMapping("")
    fun createCharacter(@RequestBody character: PlayerCharacterRequest) {
        val newCharacter = create.execute(character)

        characterService.save(newCharacter)
    }

    @DeleteMapping("{id}")
    fun deleteCharacter(@PathVariable("id") id : Long) {
        characterService.deleteById(id)
    }
}