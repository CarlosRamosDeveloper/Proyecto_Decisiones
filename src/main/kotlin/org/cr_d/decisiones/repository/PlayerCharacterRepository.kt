package org.cr_d.decisiones.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import org.cr_d.decisiones.model.PlayerCharacter
import org.cr_d.decisiones.model.User

@Repository
interface PlayerCharacterRepository : JpaRepository <PlayerCharacter, Long> {
    fun findAllByUserId(user: User): List<PlayerCharacter>
}