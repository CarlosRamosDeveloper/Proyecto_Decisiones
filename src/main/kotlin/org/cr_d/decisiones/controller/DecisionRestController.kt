package org.cr_d.decisiones.controller

import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.DecisionResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.DecisionService
import org.cr_d.decisiones.usecase.GetAllOptionsByDecisionUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/decisions")
class DecisionRestController (
    private val decisionsService: DecisionService,
    private val getOptions: GetAllOptionsByDecisionUseCase
){
    @GetMapping("")
    fun findAll(): List<DecisionResponse>{
        val response = decisionsService.findAll().map {
            val options = getOptions.execute(it)
            it.toResponse(options)
        }

        return response
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Long): DecisionResponse? {
        val response = decisionsService.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Decision not found")
        val options = getOptions.execute(response)

        return response.toResponse(options)
    }
}