package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.PlayerDecisionResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.PlayerDecisionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/playerDecisions")
class PlayerDecisionRestController (
    private val playerDecisionService: PlayerDecisionService
){
    @GetMapping("")
    fun getAll(): List<PlayerDecisionResponse> {

        return playerDecisionService.findAll().map{ it.toResponse() }
    }
}