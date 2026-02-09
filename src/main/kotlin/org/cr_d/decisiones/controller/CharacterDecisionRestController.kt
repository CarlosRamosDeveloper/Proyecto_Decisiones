package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.CharacterDecisionRequest
import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.CharacterDecisionResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.CharacterDecisionService
import org.cr_d.decisiones.usecases.CreateCharacterDecisionUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/playerDecisions")
class CharacterDecisionRestController (
    private val characterDecisionService: CharacterDecisionService,
    private val createDecision: CreateCharacterDecisionUseCase
){
    @GetMapping("")
    fun getAll(): List<CharacterDecisionResponse> {
        return characterDecisionService.findAll().map{ it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id : Long) : CharacterDecisionResponse?{
        val response = characterDecisionService.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Character decision not found")

        return response.toResponse()
    }

    @PostMapping("")
    fun create(@RequestBody request : CharacterDecisionRequest) : CharacterDecisionResponse {
        val newDecision = createDecision.execute(request)

        return characterDecisionService.save(newDecision).toResponse()
    }
}