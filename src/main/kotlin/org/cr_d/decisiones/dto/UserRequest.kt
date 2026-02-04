package org.cr_d.decisiones.dto

data class UserRequest (
    val id: Long? = null,
    val username: String = "",
    val email: String = ""
)