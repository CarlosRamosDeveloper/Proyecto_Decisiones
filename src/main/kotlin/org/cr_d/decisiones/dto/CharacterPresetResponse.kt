package org.cr_d.decisiones.dto

data class CharacterPresetResponse (
    val id : Long,
    val race: String,
    val sex: String,
    val location: String,
    val description: String
)