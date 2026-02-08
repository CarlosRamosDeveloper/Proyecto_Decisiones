package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.PlayerDecisionResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.CharacterDecisionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/playerDecisions")
class CharacterDecisionRestController (
    private val characterDecisionService: CharacterDecisionService
){
    @GetMapping("")
    fun getAll(): List<PlayerDecisionResponse> {

        return characterDecisionService.findAll().map{ it.toResponse() }
    }
}