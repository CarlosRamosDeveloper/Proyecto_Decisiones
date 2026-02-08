package org.cr_d.decisiones.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

import org.cr_d.decisiones.model.CharacterDecision
import org.cr_d.decisiones.repository.CharacterDecisionRepository

@Service
class CharacterDecisionService (
    private val characterDecisionRepository: CharacterDecisionRepository
){
    fun findAll(): List<CharacterDecision> = characterDecisionRepository.findAll()
    fun findById(playerDecisionId: Long): CharacterDecision? = characterDecisionRepository.findByIdOrNull(playerDecisionId)
    fun findByCharacter(characterId: Long): List<CharacterDecision> = characterDecisionRepository.findByPlayerCharacterId(characterId)
    fun save(characterDecision: CharacterDecision): CharacterDecision = characterDecisionRepository.save(characterDecision)
    fun delete(playerDecisionId: Long) = characterDecisionRepository.deleteById(playerDecisionId)

}