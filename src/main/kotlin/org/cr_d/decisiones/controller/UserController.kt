package org.cr_d.decisiones.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.UserRequest
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.model.User
import org.cr_d.decisiones.service.UserService

@Controller
@RequestMapping("/users")
class UserController (
    private val userService: UserService
) {
    @GetMapping("")
    fun getUsers(model: Model): String {
        model.addAttribute("title", "Listado de Usuarios")
        model.addAttribute("users", userService.getAllUsers().map{it.toResponse()})

        return "user/list"
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long, model: Model): String {
        val user = userService.getUserById(id) ?: return "redirect:/users/error"

        model.addAttribute("title", "Listado de Usuarios")
        model.addAttribute("user", user.toResponse())

        return "user/detail"
    }

    @GetMapping("/new")
    fun createUser(model: Model): String {
        val emptyUser = UserRequest()

        model.addAttribute("user", emptyUser)
        model.addAttribute("title", "Crear Usuario")

        return "user/form"
    }

    @PostMapping("")
    fun saveUser(@ModelAttribute user : User): String {
        userService.save(user)

        return "redirect:/users"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val user = userService.getUserById(id) ?: return "redirect:/users/error"

        model.addAttribute("user", user)
        model.addAttribute("title", "Actualizar Usuario")

        return "user/form"
    }

    @PostMapping("/update/{id}")
    fun updateUser(@PathVariable id: Long, @ModelAttribute user: User): String {
        userService.save(user)

        return "redirect:/users"
    }

    @GetMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): String {
        val user = userService.getUserById(id) ?: return "redirect:/users/error"

        userService.delete(user)

        return "redirect:/users"
    }

    @GetMapping("/error")
    fun userError(): String {
        return "user/error"
    }
}