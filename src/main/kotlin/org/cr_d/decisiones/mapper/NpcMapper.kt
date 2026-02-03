package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.NpcResponse
import org.cr_d.decisiones.model.NonPlayableCharacter

fun NonPlayableCharacter.toResponse(): NpcResponse {
    return NpcResponse(
        id = this.id!!,
        name = this.name,
        race = this.preset.race,
        sex = this.preset.sex,
        location = this.location.name,
        description = this.description,
    )
}