package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.UserResponse
import org.cr_d.decisiones.model.User

fun User.toResponse(): UserResponse {
    return UserResponse(
        this.id!!,
        this.username,
        this.email,
        this.characters.map{ it.toResponse() }
    )
}

