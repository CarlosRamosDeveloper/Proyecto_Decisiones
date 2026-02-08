package org.cr_d.decisiones.repository

import org.cr_d.decisiones.model.PlayerDecision
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerDecisionRepository : JpaRepository<PlayerDecision, Long> {
    fun findByPlayerCharacterId(playerId: Long): List<PlayerDecision>
}