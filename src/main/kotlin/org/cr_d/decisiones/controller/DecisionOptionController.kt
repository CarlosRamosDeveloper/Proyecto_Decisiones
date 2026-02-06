package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.DecisionOptionRequest
import org.cr_d.decisiones.dto.DecisionRequest
import org.cr_d.decisiones.repository.DecisionOptionRepository
import org.cr_d.decisiones.service.DecisionOptionService
import org.cr_d.decisiones.service.DecisionService
import org.cr_d.decisiones.usecases.CreateDecisionOptionUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(value = ["/decisionOptions"])
class DecisionOptionController (
    private val decisionOptionService: DecisionOptionService,
    private val createOption: CreateDecisionOptionUseCase,
    private val decisionsService: DecisionService
){
    @GetMapping(value = [""])
    fun getAll(model: Model): String{
        model.addAttribute("title", "Listado de opciones de decisiones")
        model.addAttribute("decision_options", decisionOptionService.findAll())

        return "decision_option/list"
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long, model: Model): String {
        val decision = decisionOptionService.findById(id) ?: return "redirect:/decision/error"

        model.addAttribute("title", "Información de la opción de decisión")
        model.addAttribute("decision_options", decision)

        return "decision_option/detail"
    }

    @GetMapping("/new")
    fun create(model: Model): String {
        val emptyOption = DecisionOptionRequest(null, null, "")
        model.addAttribute("decision_option", emptyOption)
        model.addAttribute("decisions", decisionsService.findAll())
        model.addAttribute("title", "Crear Decisión")

        return "decision_option/form"
    }

    @PostMapping("")
    fun save(@ModelAttribute decision : DecisionOptionRequest): String {
        val decision = createOption.execute(decision)

        decisionOptionService.save(decision)

        return "redirect:/decisionOptions"
    }

}