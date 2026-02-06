package org.cr_d.decisiones.dto

data class DecisionRequest(
    val id: Long? = null,
    val key: String,
    val description: String? = null,
)
