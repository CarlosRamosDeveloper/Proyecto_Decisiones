package org.cr_d.decisiones.dto

data class PlayerDecisionRequest (
    val id: Long? = null,
    val characterId: Long = 0,
    val decisionId: Long = 0,
    val optionId: Long = 0,
)