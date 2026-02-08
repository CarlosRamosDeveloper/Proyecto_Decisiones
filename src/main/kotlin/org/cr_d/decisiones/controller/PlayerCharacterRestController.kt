package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.CharacterResponse
import org.cr_d.decisiones.dto.CharacterRequest
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.PlayerCharacterService
import org.cr_d.decisiones.usecases.CreateCharacterUseCase
import org.cr_d.decisiones.usecases.GetCharacterByUsernameUseCase
import org.cr_d.decisiones.usecases.GetCharacterDecisionsByCharacterIdUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/characters")
class PlayerCharacterRestController (
    private val characterService: PlayerCharacterService,
    private val create: CreateCharacterUseCase,
    private val getByUser: GetCharacterByUsernameUseCase,
    private val getDecisions: GetCharacterDecisionsByCharacterIdUseCase
) {
    @GetMapping("")
    fun findAll(): List<CharacterResponse> {
        val characters = characterService.getAllCharacters().map{ it.toResponse() }

        return characters;
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Long): CharacterResponse? {
        val character = characterService.getCharacterById(id) ?: return null
        val decisions = getDecisions.execute(character.id!!)

        return character.toResponse(decisions)
    }

    @GetMapping("/by-user/{userId}")
    fun findByUsername(@PathVariable userId : Long) : List<CharacterResponse>? {
        return getByUser.execute(userId).map{ it.toResponse() }
    }

    @PostMapping("")
    fun createCharacter(@RequestBody character: CharacterRequest) {
        val newCharacter = create.execute(character)

        characterService.save(newCharacter)
    }

    @DeleteMapping("{id}")
    fun deleteCharacter(@PathVariable id : Long) {
        characterService.deleteById(id)
    }
}