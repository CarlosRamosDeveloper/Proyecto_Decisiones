package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.CharacterResponse
import org.cr_d.decisiones.model.PlayerCharacter

fun PlayerCharacter.toResponse(): CharacterResponse {
    return CharacterResponse(
        id = this.id!!,
        user = this.userId.username,
        name = this.name,
        location = this.lastLocationId.name,
        race = this.presetId.race,
        sex = this.presetId.sex
    )
}