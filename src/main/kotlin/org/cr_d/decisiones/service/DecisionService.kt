package org.cr_d.decisiones.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

import org.cr_d.decisiones.model.Decision
import org.cr_d.decisiones.repository.DecisionRepository

@Service
class DecisionService (
    private val decisionRepository: DecisionRepository
){
    fun findAll(): List<Decision> = decisionRepository.findAll()
    fun findById(decisionId: Long): Decision? = decisionRepository.findByIdOrNull(decisionId)
    fun save(decision: Decision): Decision = decisionRepository.save(decision)
    fun delete(id: Long) = decisionRepository.deleteById(id)
    fun count(): Long = decisionRepository.count()
}