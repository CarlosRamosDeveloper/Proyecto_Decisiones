package org.cr_d.decisiones.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import org.cr_d.decisiones.model.CharacterDecision

@Repository
interface CharacterDecisionRepository : JpaRepository<CharacterDecision, Long> {
    fun findByPlayerCharacterId(playerId: Long): List<CharacterDecision>
}