package org.cr_d.decisiones.repository

import org.cr_d.decisiones.model.PlayerCharacter
import org.cr_d.decisiones.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerCharacterRepository : JpaRepository <PlayerCharacter, Long> {
    fun findAllByUserId(user: User): List<PlayerCharacter>
}