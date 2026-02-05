package org.cr_d.decisiones.controller

import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.UserResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.model.User
import org.cr_d.decisiones.service.UserService

@RestController
@RequestMapping("/api/users")
class UserRestController (
    private val userService: UserService
){
    @GetMapping("")
    fun getUsers() : List<UserResponse>{
        return userService.getAllUsers().map{ it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id : Long) : UserResponse?{
        val user = userService.getUserById(id)

        if (user != null) return user.toResponse()

        return null
    }

    @GetMapping("/email")
    fun getUserByEmail(@RequestParam("email") email: String) : UserResponse?{
        val user = userService.getUserByEmail(email)

        if (user != null) return user.toResponse()

        return null
    }

    @PostMapping("")
    fun createUser(@RequestBody user: User){
        userService.save(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id : Long){
        val user = userService.getUserById(id)
        if (user != null){
            userService.delete(user)
        }
    }
}