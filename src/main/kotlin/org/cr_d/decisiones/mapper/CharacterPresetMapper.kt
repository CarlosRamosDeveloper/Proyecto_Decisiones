package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.CharacterPresetResponse
import org.cr_d.decisiones.model.CharacterPreset

fun CharacterPreset.toResponse(): CharacterPresetResponse {
    return CharacterPresetResponse(
        id= id!!,
        race = race,
        sex = sex,
        description = description,
        location = location.name
    )
}