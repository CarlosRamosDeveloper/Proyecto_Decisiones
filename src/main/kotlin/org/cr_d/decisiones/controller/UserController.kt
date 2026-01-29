package org.cr_d.decisiones.controller

import org.cr_d.decisiones.model.User
import org.cr_d.decisiones.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class UserController (
    private val userService: UserService
) {
    @GetMapping("/users")
    fun getUsers(model: Model): String {
        model.addAttribute("users", userService.getAllUsers())

        return "a"
    }

    @GetMapping("/users/new")
    fun createUser(@ModelAttribute model: Model): String {
        val emptyUser = User(0, "", email = "")

        model.addAttribute("user", emptyUser)
        model.addAttribute("title", "Agregar nuevo usuario")
        return "a"
    }

    @PostMapping
    fun saveUser(@ModelAttribute user: User): String {
        userService.save(user)

        return "A"
    }

}