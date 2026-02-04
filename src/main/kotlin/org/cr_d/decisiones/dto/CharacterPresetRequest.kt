package org.cr_d.decisiones.dto

data class CharacterPresetRequest(
    val id: Long,
    val race: String,
    val sex: String,
    val locationId: Long,
    val description: String
)
