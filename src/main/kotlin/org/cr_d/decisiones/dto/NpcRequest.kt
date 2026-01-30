package org.cr_d.decisiones.dto

data class NpcRequest(
    val presetId: Long,
    val name: String,
    val locationId: Long,
    val description: String
)