package org.cr_d.decisiones.controller

import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.CharacterDecisionResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.CharacterDecisionService

@RestController
@RequestMapping("/api/playerDecisions")
class CharacterDecisionRestController (
    private val characterDecisionService: CharacterDecisionService
){
    @GetMapping("")
    fun getAll(): List<CharacterDecisionResponse> {
        return characterDecisionService.findAll().map{ it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id : Long) : CharacterDecisionResponse?{
        val response = characterDecisionService.findById(id) ?: return null

        return response.toResponse()
    }
}