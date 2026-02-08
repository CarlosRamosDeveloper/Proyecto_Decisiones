package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.model.PlayerDecision
import org.cr_d.decisiones.service.PlayerDecisionService
import org.springframework.stereotype.Service

@Service
class GetPlayerDecisionsByCharacterIdUseCase (
    private val playerDecisionService: PlayerDecisionService
){
    fun execute(characterId: Long): List<PlayerDecision>{
        return playerDecisionService.findByCharacter(characterId)
    }
}