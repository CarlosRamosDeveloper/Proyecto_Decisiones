package org.cr_d.decisiones.controller

import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.DecisionOptionService
import org.cr_d.decisiones.service.DecisionService
import org.cr_d.decisiones.service.PlayerCharacterService
import org.cr_d.decisiones.service.PlayerDecisionService
import org.cr_d.decisiones.usecases.CreatePlayerDecisionUseCase
import org.cr_d.decisiones.usecases.UpdatePlayerDecisionUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/playerDecisions")
class PlayerDecisionController (
    private val playerDecisionService: PlayerDecisionService,
    private val create: CreatePlayerDecisionUseCase,
    private val update: UpdatePlayerDecisionUseCase,
    private val characterService: PlayerCharacterService,
    private val decisionService: DecisionService,
    private val decisionOptionService: DecisionOptionService
){
    @GetMapping("")
    fun getAll(model: Model): String {
        model.addAttribute("title","")
        model.addAttribute("player_decisions", playerDecisionService.findAll().map{ it.toResponse() })

        return "player_decision/list"
    }
}