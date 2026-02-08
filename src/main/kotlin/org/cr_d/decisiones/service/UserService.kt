package org.cr_d.decisiones.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

import org.cr_d.decisiones.model.User
import org.cr_d.decisiones.repository.UserRepository

@Service
class UserService(
    val repository: UserRepository,
) {
    fun getAllUsers(): List<User> = repository.findAll()
    fun getUserById(id: Long): User? = repository.findByIdOrNull(id)
    fun getUserByEmail(email: String): User? = repository.findByEmail(email)
    fun save(user: User): User = repository.save(user)
    fun delete(user: User) = repository.delete(user)
}