package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.DecisionOptionResponse
import org.cr_d.decisiones.model.DecisionOption

fun DecisionOption.toResponse(): DecisionOptionResponse {
    return DecisionOptionResponse(
        id = this.id!!,
        decisionId = decision.id!!,
        decision = decision.description!!,
        value = this.key,
        displayText = this.displayText,
        text = this.text!!
    )
}