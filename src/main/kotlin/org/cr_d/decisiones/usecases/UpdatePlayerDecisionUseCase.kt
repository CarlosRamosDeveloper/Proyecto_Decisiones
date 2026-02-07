package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.dto.PlayerDecisionRequest
import org.cr_d.decisiones.model.PlayerDecision
import org.cr_d.decisiones.service.DecisionOptionService
import org.cr_d.decisiones.service.DecisionService
import org.cr_d.decisiones.service.PlayerCharacterService
import org.cr_d.decisiones.service.PlayerDecisionService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UpdatePlayerDecisionUseCase(
    private val playerDecisionService: PlayerDecisionService,
    private val characterService: PlayerCharacterService,
    private val decisionService: DecisionService,
    private val optionService: DecisionOptionService
) {
    fun execute(playerDecision: PlayerDecisionRequest, id: Long): PlayerDecision {
        val exists = playerDecisionService.findById(id)
        val character = characterService.getCharacterById(playerDecision.characterId)
        val decision = decisionService.findById(playerDecision.decisionId)
        val option = optionService.findById(playerDecision.optionId)

        return PlayerDecision(
            id = id,
            playerCharacter = character!!,
            decision = decision!!,
            decisionOption = option!!,
            createdAt = exists?.createdAt ?: LocalDateTime.now(),
        )
    }
}