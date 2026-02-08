package org.cr_d.decisiones.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

import org.cr_d.decisiones.model.Decision
import org.cr_d.decisiones.model.DecisionOption
import org.cr_d.decisiones.repository.DecisionOptionRepository

@Service
class DecisionOptionService (
    private val decisionOptionRepository: DecisionOptionRepository
) {
    fun findAll(): List<DecisionOption> = decisionOptionRepository.findAll()
    fun findById(decisionOptionId: Long): DecisionOption? = decisionOptionRepository.findByIdOrNull(decisionOptionId)
    fun findByDecision(decision: Decision): List<DecisionOption> = decisionOptionRepository.findAllByDecision(decision)
    fun save(decisionOption: DecisionOption): DecisionOption = decisionOptionRepository.save(decisionOption)
    fun delete(decisionOptionId: Long) = decisionOptionRepository.deleteById(decisionOptionId)
    fun count(): Long = decisionOptionRepository.count()
}