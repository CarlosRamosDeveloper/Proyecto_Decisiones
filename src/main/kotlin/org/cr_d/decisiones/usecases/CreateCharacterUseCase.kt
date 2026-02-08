package org.cr_d.decisiones.usecases

import org.springframework.stereotype.Service

import org.cr_d.decisiones.dto.CharacterRequest
import org.cr_d.decisiones.model.PlayerCharacter
import org.cr_d.decisiones.service.CharacterPresetService
import org.cr_d.decisiones.service.LocationService
import org.cr_d.decisiones.service.UserService

@Service
class CreateCharacterUseCase (
    private val userService: UserService,
    private val presetService: CharacterPresetService,
    private val locationService: LocationService,
){
    fun execute(character: CharacterRequest, id: Long? = null) : PlayerCharacter {
        val user = userService.getUserById(character.userId) ?: throw RuntimeException("Usuario no encontrado")
        val preset = presetService.getPresetById(character.presetId) ?: throw RuntimeException("Preset no encontrado")
        val location = locationService.getLocationById(preset.location.id!!) ?: throw RuntimeException("Ubicación no encontrada")

        return PlayerCharacter(
            id = id,
            userId = user,
            presetId = preset,
            name = character.name,
            lastLocationId = location
        )
    }
}