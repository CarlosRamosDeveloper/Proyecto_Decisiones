package org.cr_d.decisiones.dto

data class DecisionOptionResponse (
    val id: Long,
    val decisionId: Long,
    val decision: String,
    val value: String,
    val displayText: String,
    val text: String,
)