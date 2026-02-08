package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.model.CharacterDecision
import org.cr_d.decisiones.service.CharacterDecisionService
import org.springframework.stereotype.Service

@Service
class GetCharacterDecisionsByCharacterIdUseCase (
    private val characterDecisionService: CharacterDecisionService
){
    fun execute(characterId: Long): List<CharacterDecision>{
        return characterDecisionService.findByCharacter(characterId)
    }
}