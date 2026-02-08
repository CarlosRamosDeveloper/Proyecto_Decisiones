package org.cr_d.decisiones.controller

import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.DecisionOptionResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.DecisionOptionService

@RestController
@RequestMapping("/api/decisionOptions")
class DecisionOptionRestController (
    private val decisionOptionService: DecisionOptionService
){
    @GetMapping("")
    fun findAll(): List<DecisionOptionResponse> {
        return decisionOptionService.findAll().map{ it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Long): DecisionOptionResponse? {
        val response = decisionOptionService.findById(id) ?: return null

        return response.toResponse()
    }
}