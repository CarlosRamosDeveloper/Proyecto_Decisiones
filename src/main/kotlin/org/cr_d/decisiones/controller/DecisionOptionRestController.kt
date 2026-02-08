package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.DecisionOptionResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.DecisionOptionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/decisionOptions")
class DecisionOptionRestController (
    private val decisionOptionService: DecisionOptionService
){
    @GetMapping("")
    fun findAll(): List<DecisionOptionResponse> {
        return decisionOptionService.findAll().map{ it.toResponse() }
    }

}