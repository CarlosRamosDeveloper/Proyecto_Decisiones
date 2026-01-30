package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.PlayerCharacterRequest
import org.cr_d.decisiones.model.PlayerCharacter
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
    fun findAll(): List<PlayerCharacter> {
        return characterService.getAllCharacters()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id : Long): PlayerCharacter? {
        return characterService.getCharacterById(id)
    }

    @GetMapping("/by-user/{userId}")
    fun findByUsername(@PathVariable("userId") userId : Long) : List<PlayerCharacter>? {
        return getByUser.execute(userId)
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