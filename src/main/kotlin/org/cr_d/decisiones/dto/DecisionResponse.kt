package org.cr_d.decisiones.dto

data class DecisionResponse(
    val id: Long,
    val key: String,
    val description: String,
    val options: List<DecisionOptionResponse>
)