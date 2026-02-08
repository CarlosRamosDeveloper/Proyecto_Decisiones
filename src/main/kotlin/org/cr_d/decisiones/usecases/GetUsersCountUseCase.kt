package org.cr_d.decisiones.usecases

import org.springframework.stereotype.Service

import org.cr_d.decisiones.service.UserService

@Service
class GetUsersCountUseCase (
    private val userService: UserService,
) {
    fun execute(): Int {
        return userService.getAllUsers().count()
    }
}