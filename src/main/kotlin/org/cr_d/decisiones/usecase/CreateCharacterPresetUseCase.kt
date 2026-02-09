package org.cr_d.decisiones.usecase

import org.springframework.stereotype.Service

import org.cr_d.decisiones.dto.CharacterPresetRequest
import org.cr_d.decisiones.model.CharacterPreset
import org.cr_d.decisiones.service.LocationService

@Service
class CreateCharacterPresetUseCase(
    private val locationService: LocationService,
) {
    fun execute(preset: CharacterPresetRequest, id: Long? = null): CharacterPreset? {
        val location = locationService.getLocationById(preset.locationId)

        if (location != null) {
            return CharacterPreset(
                id = id,
                race = preset.race,
                sex = preset.sex,
                description = preset.description,
                location = location
            )
        }

        return null
    }
}