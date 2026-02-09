package org.cr_d.decisiones.controller

import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.DecisionOptionResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.DecisionOptionService
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

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
        val response = decisionOptionService.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Preset not found")

        return response.toResponse()
    }
}