package org.cr_d.decisiones.usecase

import org.springframework.stereotype.Service
import java.time.LocalDateTime

import org.cr_d.decisiones.dto.CharacterDecisionRequest
import org.cr_d.decisiones.model.CharacterDecision
import org.cr_d.decisiones.service.DecisionOptionService
import org.cr_d.decisiones.service.DecisionService
import org.cr_d.decisiones.service.PlayerCharacterService
import org.cr_d.decisiones.service.CharacterDecisionService

@Service
class UpdateCharacterDecisionUseCase(
    private val characterDecisionService: CharacterDecisionService,
    private val characterService: PlayerCharacterService,
    private val decisionService: DecisionService,
    private val optionService: DecisionOptionService
) {
    fun execute(playerDecision: CharacterDecisionRequest, id: Long): CharacterDecision {
        val exists = characterDecisionService.findById(id)
        val character = characterService.getCharacterById(playerDecision.characterId)
        val decision = decisionService.findById(playerDecision.decisionId)
        val option = optionService.findById(playerDecision.optionId)

        return CharacterDecision(
            id = id,
            playerCharacter = character!!,
            decision = decision!!,
            decisionOption = option!!,
            createdAt = exists?.createdAt ?: LocalDateTime.now(),
        )
    }
}