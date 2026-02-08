package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.DecisionResponse
import org.cr_d.decisiones.model.Decision
import org.cr_d.decisiones.model.DecisionOption

fun Decision.toResponse(options: List<DecisionOption> = emptyList()): DecisionResponse {
    return DecisionResponse(
        id  = this.id!!,
        key = this.key,
        description = this.description!!,
        options = options.map { it.toResponse() }
    )
}