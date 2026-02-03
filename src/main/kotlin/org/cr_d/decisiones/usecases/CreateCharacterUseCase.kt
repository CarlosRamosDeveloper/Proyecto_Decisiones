package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.dto.PlayerCharacterRequest
import org.cr_d.decisiones.model.PlayerCharacter
import org.cr_d.decisiones.service.CharacterPresetService
import org.cr_d.decisiones.service.LocationService
import org.cr_d.decisiones.service.UserService
import org.springframework.stereotype.Service

@Service
class CreateCharacterUseCase (
    private val userService: UserService,
    private val presetService: CharacterPresetService,
    private val locationService: LocationService,
){
    fun execute(character: PlayerCharacterRequest) : PlayerCharacter {
        val user = userService.getUserById(character.userId) ?: throw RuntimeException("Usuario no encontrado")
        val preset = presetService.getPresetById(character.presetId) ?: throw RuntimeException("Preset no encontrado")
        val location = locationService.getLocationById(preset.location.id!!) ?: throw RuntimeException("Ubicación no encontrada")

        return PlayerCharacter(
            id = null,
            userId = user,
            presetId = preset,
            name = character.name,
            lastLocationId = location
        )
    }
}