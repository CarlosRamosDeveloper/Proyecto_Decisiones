package org.cr_d.decisiones.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import org.cr_d.decisiones.model.User

@Repository
interface UserRepository : JpaRepository<User, Long>{
    fun findByEmail(email: String): User?
}