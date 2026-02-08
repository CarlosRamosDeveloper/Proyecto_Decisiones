package org.cr_d.decisiones.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class CharacterDecisionResponse (
    val id: Long,
    val characterName: String,
    val decision: String,
    val option: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    val createdAt: LocalDateTime,
)