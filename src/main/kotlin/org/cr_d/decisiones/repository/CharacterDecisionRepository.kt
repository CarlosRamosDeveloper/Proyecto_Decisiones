package org.cr_d.decisiones.repository

import org.cr_d.decisiones.model.CharacterDecision
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CharacterDecisionRepository : JpaRepository<CharacterDecision, Long> {
    fun findByPlayerCharacterId(playerId: Long): List<CharacterDecision>
}