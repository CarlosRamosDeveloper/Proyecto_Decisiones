package org.cr_d.decisiones.usecase

import org.springframework.stereotype.Service

import org.cr_d.decisiones.dto.DecisionOptionRequest
import org.cr_d.decisiones.model.DecisionOption
import org.cr_d.decisiones.service.DecisionService

@Service
class CreateDecisionOptionUseCase (
    val decisionService: DecisionService,
){
    fun execute(decisionOption: DecisionOptionRequest, id: Long?=null): DecisionOption {
        val decision = decisionService.findById(decisionOption.decisionId!!)

        return DecisionOption(
            id = id,
            decision = decision!!,
            key = decisionOption.key,
            displayText = decisionOption.displayText!!,
            text = decisionOption.text,
        )
    }
}