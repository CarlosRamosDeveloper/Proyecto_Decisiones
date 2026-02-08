package org.cr_d.decisiones.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import org.cr_d.decisiones.model.Decision
import org.cr_d.decisiones.model.DecisionOption

@Repository
interface DecisionOptionRepository : JpaRepository<DecisionOption, Long> {
    fun findAllByDecision(decision: Decision): List<DecisionOption>
}