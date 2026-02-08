package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.DecisionResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.DecisionService
import org.cr_d.decisiones.usecases.GetAllOptionsByDecisionUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
        val response = decisionsService.findById(id) ?: return null
        val options = getOptions.execute(response)

        return response.toResponse(options)
    }
}