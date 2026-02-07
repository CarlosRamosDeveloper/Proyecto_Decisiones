package org.cr_d.decisiones.dto

import java.time.LocalDateTime

data class PlayerDecisionResponse (
    val id: Long,
    val characterName: String,
    val decision: String,
    val option: String,
    val createdAt: LocalDateTime,
)