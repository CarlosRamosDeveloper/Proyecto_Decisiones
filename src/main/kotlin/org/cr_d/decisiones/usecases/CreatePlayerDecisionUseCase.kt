package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.dto.CharacterDecisionRequest
import org.cr_d.decisiones.model.CharacterDecision
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
    fun execute(playerDecision: CharacterDecisionRequest): CharacterDecision {
        val character = characterService.getCharacterById(playerDecision.characterId)
        val decision = decisionService.findById(playerDecision.decisionId)
        val option = optionService.findById(playerDecision.optionId)

        return CharacterDecision(
            playerCharacter = character!!,
            decision = decision!!,
            decisionOption = option!!,
        )
    }
}