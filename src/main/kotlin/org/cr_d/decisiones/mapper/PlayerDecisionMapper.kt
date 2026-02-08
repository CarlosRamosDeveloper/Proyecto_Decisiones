package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.PlayerDecisionResponse
import org.cr_d.decisiones.model.PlayerDecision

fun PlayerDecision.toResponse(): PlayerDecisionResponse{
    return PlayerDecisionResponse(
        id = this.id!!,
        characterName = this.playerCharacter.name,
        decision = this.decision.description!!,
        option = this.decisionOption.text!!,
        createdAt = createdAt,
    )
}