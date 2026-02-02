package org.cr_d.decisiones.controller

import org.cr_d.decisiones.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/users")
class UserController (
    private val userService: UserService
) {
    @GetMapping("")
    fun getUsers(model: Model): String {
        model.addAttribute("title", "Listado de Usuarios")
        model.addAttribute("users", userService.getAllUsers())

        return "user/list"
    }
}