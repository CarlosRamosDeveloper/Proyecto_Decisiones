package org.cr_d.decisiones.usecases

import org.springframework.stereotype.Service

import org.cr_d.decisiones.model.CharacterDecision
import org.cr_d.decisiones.service.CharacterDecisionService

@Service
class GetCharacterDecisionsByCharacterIdUseCase (
    private val characterDecisionService: CharacterDecisionService
){
    fun execute(characterId: Long): List<CharacterDecision>{
        return characterDecisionService.findByCharacter(characterId)
    }
}