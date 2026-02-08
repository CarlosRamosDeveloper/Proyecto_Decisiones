package org.cr_d.decisiones.service

import org.cr_d.decisiones.model.PlayerDecision
import org.cr_d.decisiones.repository.PlayerDecisionRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PlayerDecisionService (
    private val playerDecisionRepository: PlayerDecisionRepository
){
    fun findAll(): List<PlayerDecision> = playerDecisionRepository.findAll()
    fun findById(playerDecisionId: Long): PlayerDecision? = playerDecisionRepository.findByIdOrNull(playerDecisionId)
    fun findByCharacter(characterId: Long): List<PlayerDecision> = playerDecisionRepository.findByPlayerCharacterId(characterId)
    fun save(playerDecision: PlayerDecision): PlayerDecision = playerDecisionRepository.save(playerDecision)
    fun delete(playerDecisionId: Long) = playerDecisionRepository.deleteById(playerDecisionId)

}