package org.cr_d.decisiones.dto

data class CharacterResponse (
    val id : Long,
    val user: String,
    val name: String,
    val location: String,
    val race: String,
    val sex: String
)