package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.dto.DecisionOptionRequest
import org.cr_d.decisiones.model.DecisionOption
import org.cr_d.decisiones.service.DecisionService
import org.springframework.stereotype.Service

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
            text = decisionOption.text,
        )
    }
}