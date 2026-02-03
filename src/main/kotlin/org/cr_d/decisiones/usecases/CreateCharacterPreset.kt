package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.dto.CharacterPresetRequest
import org.cr_d.decisiones.model.CharacterPreset
import org.cr_d.decisiones.service.LocationService
import org.springframework.stereotype.Service

@Service
class CreateCharacterPreset(
    private val locationService: LocationService,
) {
    fun execute(preset: CharacterPresetRequest): CharacterPreset? {
        val location = locationService.getLocationById(preset.locationId)

        if (location != null) {
            return CharacterPreset(
                id = null,
                race = preset.race,
                sex = preset.sex,
                description = preset.description,
                location = location
            )
        }

        return null
    }
}