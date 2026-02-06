package org.cr_d.decisiones.dto

data class DecisionOptionRequest(
    val id: Long? = null,
    val decisionId: Long? = null,
    val key: String,
    val text: String? = null,
)
