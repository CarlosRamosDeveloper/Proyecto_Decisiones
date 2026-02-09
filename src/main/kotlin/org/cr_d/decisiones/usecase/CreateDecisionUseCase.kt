package org.cr_d.decisiones.usecase

import org.springframework.stereotype.Service

import org.cr_d.decisiones.dto.DecisionRequest
import org.cr_d.decisiones.model.Decision

@Service
class CreateDecisionUseCase {
    fun execute(decision: DecisionRequest, id: Long? = null): Decision {
        return Decision(
            id = id,
            key = decision.key,
            description = decision.description,
        )
    }
}