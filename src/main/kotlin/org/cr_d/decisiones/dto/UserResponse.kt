package org.cr_d.decisiones.dto

data class UserResponse (
    val id: Long,
    val username: String,
    val email: String,
    val characters: List<CharacterResponse>
)