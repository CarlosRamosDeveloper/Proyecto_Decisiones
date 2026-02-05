package org.cr_d.decisiones.dto

data class LocationRestResponse(
    val id: Long,
    val name: String,
    val description: String,
    val npcs: List<NpcResponse>
)