package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.dto.PlayerDecisionRequest
import org.cr_d.decisiones.model.PlayerDecision
import org.cr_d.decisiones.service.DecisionOptionService
import org.cr_d.decisiones.service.DecisionService
import org.cr_d.decisiones.service.PlayerCharacterService
import org.springframework.stereotype.Service

@Service
class CreatePlayerDecisionUseCase (
    private val characterService: PlayerCharacterService,
    private val decisionService: DecisionService,
    private val optionService: DecisionOptionService
) {
    fun execute(playerDecision: PlayerDecisionRequest): PlayerDecision {
        val character = characterService.getCharacterById(playerDecision.characterId)
        val decision = decisionService.findById(playerDecision.decisionId)
        val option = optionService.findById(playerDecision.optionId)

        return PlayerDecision(
            playerCharacter = character!!,
            decision = decision!!,
            decisionOption = option!!,
        )
    }
}