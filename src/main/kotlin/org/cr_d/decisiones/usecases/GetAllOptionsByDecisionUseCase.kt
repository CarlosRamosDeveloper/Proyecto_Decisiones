package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.model.Decision
import org.cr_d.decisiones.model.DecisionOption
import org.cr_d.decisiones.service.DecisionOptionService
import org.springframework.stereotype.Service

@Service
class GetAllOptionsByDecisionUseCase(
    private val decisionOptionService: DecisionOptionService,
) {
    fun execute(decision: Decision): List<DecisionOption> {
        return decisionOptionService.findByDecision(decision)
    }
}