package org.cr_d.decisiones.controller

import org.cr_d.decisiones.model.User
import org.cr_d.decisiones.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UserRestController (
    private val userService: UserService
){
    @GetMapping("/users")
    fun getUsers() : List<User>{
        return userService.getAllUsers()
    }

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable("id") id : Long) : User?{
        return userService.getUserById(id)
    }

    @GetMapping("/users/email")
    fun getUserByEmail(@RequestParam("email") email: String) : User?{
        return userService.getUserByEmail(email)
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: User){
        userService.save(user)
    }

    @DeleteMapping("/users/{id}")
    fun deleteUserById(@PathVariable("id") id : Long){
        userService.delete(id)
    }

}