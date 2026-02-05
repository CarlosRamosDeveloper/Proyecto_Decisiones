package org.cr_d.decisiones.dto

data class CharacterRequest(
    val id : Long? = null,
    val userId: Long,
    val presetId: Long,
    val name: String
)
