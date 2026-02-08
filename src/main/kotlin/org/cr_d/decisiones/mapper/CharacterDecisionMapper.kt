package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.CharacterDecisionResponse
import org.cr_d.decisiones.model.CharacterDecision

fun CharacterDecision.toResponse(): CharacterDecisionResponse{
    return CharacterDecisionResponse(
        id = this.id!!,
        characterName = this.playerCharacter.name,
        decision = this.decision.description!!,
        option = this.decisionOption.displayText,
        createdAt = createdAt,
    )
}