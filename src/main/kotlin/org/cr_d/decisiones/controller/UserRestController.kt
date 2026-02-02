package org.cr_d.decisiones.controller

import org.cr_d.decisiones.model.User
import org.cr_d.decisiones.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserRestController (
    private val userService: UserService
){
    @GetMapping("")
    fun getUsers() : List<User>{
        return userService.getAllUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id : Long) : User?{
        return userService.getUserById(id)
    }

    @GetMapping("/email")
    fun getUserByEmail(@RequestParam("email") email: String) : User?{
        return userService.getUserByEmail(email)
    }

    @PostMapping("")
    fun createUser(@RequestBody user: User){
        userService.save(user)
    }

    //TODO: Eliminar del rest controller cuando esté corriendo el modo admin
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id : Long){
        val user = userService.getUserById(id)
        if (user != null){
            userService.delete(user)
        }
    }

}