package org.cr_d.decisiones.dto

data class NpcResponse (
    val id: Long,
    val name: String,
    val race: String,
    val sex: String,
    val description: String,
    val location: String
)