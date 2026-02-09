package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.UserRequest
import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.UserResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.model.User
import org.cr_d.decisiones.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

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
        val user = userService.getUserById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")

        return user.toResponse()
    }

    @GetMapping("/email")
    fun getUserByEmail(@RequestParam("email") email: String) : UserResponse?{
        val user = userService.getUserByEmail(email) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")

        return user.toResponse()
    }

    @PostMapping("")
    fun createUser(@RequestBody user: User) : UserResponse{
        return userService.save(user).toResponse()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: UserRequest): UserResponse {
        val user = userService.getUserById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")

        val updatedCharacter = user.copy(
            email = request.email ,
            username = request.username,
        )

        return userService.save(updatedCharacter).toResponse()
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id : Long){
        val user = userService.getUserById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")

        userService.delete(user)
    }
}