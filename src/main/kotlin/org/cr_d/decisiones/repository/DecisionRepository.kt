package org.cr_d.decisiones.repository

import org.cr_d.decisiones.model.Decision
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DecisionRepository: JpaRepository<Decision, Long> {
}