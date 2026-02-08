package org.cr_d.decisiones.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

import org.cr_d.decisiones.dto.CharacterResponse
import org.cr_d.decisiones.dto.CharacterRequest
import org.cr_d.decisiones.dto.UpdateCharacterLocationRequest
import org.cr_d.decisiones.dto.UpdateCharacterNameRequest
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.LocationService
import org.cr_d.decisiones.service.PlayerCharacterService
import org.cr_d.decisiones.usecases.CreateCharacterUseCase
import org.cr_d.decisiones.usecases.GetCharacterByUsernameUseCase
import org.cr_d.decisiones.usecases.GetCharacterDecisionsByCharacterIdUseCase

@RestController
@RequestMapping("/api/characters")
class PlayerCharacterRestController (
    private val characterService: PlayerCharacterService,
    private val create: CreateCharacterUseCase,
    private val getByUser: GetCharacterByUsernameUseCase,
    private val getDecisions: GetCharacterDecisionsByCharacterIdUseCase,
    private val locationService: LocationService
) {
    @GetMapping("")
    fun findAll(): List<CharacterResponse> {
        val characters = characterService.getAllCharacters().map{ it.toResponse() }

        return characters;
    }

    @GetMapping("/{id}")
    fun findById(
        @PathVariable id : Long
    ): CharacterResponse? {
        val character = characterService.getCharacterById(id) ?: return null
        val decisions = getDecisions.execute(character.id!!)

        return character.toResponse(decisions)
    }

    @GetMapping("/by-user/{userId}")
    fun findByUsername(
        @PathVariable userId : Long
    ) : List<CharacterResponse>? {
        return getByUser.execute(userId).map{ it.toResponse() }
    }

    @PostMapping("")
    fun createCharacter(
        @RequestBody character: CharacterRequest
    ) : CharacterResponse {
        val newCharacter = create.execute(character)

        return characterService.save(newCharacter).toResponse()
    }

    @PatchMapping("/{id}")
    fun updateName(
        @PathVariable id: Long,
        @RequestBody request: UpdateCharacterNameRequest
    ): CharacterResponse {
        val character = characterService.getCharacterById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found")

        val updatedCharacter = character.copy(name = request.name)

        characterService.save(updatedCharacter)

        return updatedCharacter.toResponse()
    }

    @PatchMapping("/{id}/location")
    fun updateLastLocation(
        @PathVariable id: Long,
        @RequestBody request: UpdateCharacterLocationRequest
    ): CharacterResponse {

        val character = characterService.getCharacterById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found")

        val location = locationService.getLocationById(request.locationId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found")

        val updatedCharacter = character.copy(
            lastLocationId = location
        )

        characterService.save(updatedCharacter)

        return updatedCharacter.toResponse()
    }


    @DeleteMapping("{id}")
    fun deleteCharacter(@PathVariable id : Long) {
        characterService.deleteById(id)
    }
}