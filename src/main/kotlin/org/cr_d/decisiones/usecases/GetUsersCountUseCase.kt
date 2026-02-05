package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.service.UserService
import org.springframework.stereotype.Service

@Service
class GetUsersCountUseCase (
    private val userService: UserService,
) {
    fun execute(): Int {
        return userService.getAllUsers().count()
    }
}