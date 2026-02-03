package org.cr_d.decisiones.dto

data class PlayerCharacterRequest(
    val userId: Long,
    val presetId: Long,
    val name: String
)
