package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.CharacterResponse
import org.cr_d.decisiones.model.PlayerCharacter
import org.cr_d.decisiones.model.CharacterDecision

fun PlayerCharacter.toResponse(decisions: List<CharacterDecision> = emptyList()): CharacterResponse {
    return CharacterResponse(
        id = this.id!!,
        user = this.userId.username,
        name = this.name,
        location = this.lastLocationId.name,
        race = this.presetId.race,
        sex = this.presetId.sex,
        decisions = decisions.map { it.toResponse() },
    )
}