package org.cr_d.decisiones.dto

data class CharacterDecisionRequest (
    val id: Long? = null,
    val characterId: Long = 0,
    val decisionId: Long = 0,
    val optionId: Long = 0,
)