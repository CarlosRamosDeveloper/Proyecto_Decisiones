package org.cr_d.decisiones.repository

import org.cr_d.decisiones.model.Decision
import org.cr_d.decisiones.model.DecisionOption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DecisionOptionRepository : JpaRepository<DecisionOption, Long> {
    fun findAllByDecision(decision: Decision): List<DecisionOption>
}