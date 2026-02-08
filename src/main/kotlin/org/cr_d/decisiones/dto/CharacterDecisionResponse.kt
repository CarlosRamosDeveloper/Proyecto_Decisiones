package org.cr_d.decisiones.dto

import java.time.LocalDateTime

import com.fasterxml.jackson.annotation.JsonFormat

data class CharacterDecisionResponse (
    val id: Long,
    val characterName: String,
    val decision: String,
    val option: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    val createdAt: LocalDateTime,
)