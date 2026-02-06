package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.DecisionRequest
import org.cr_d.decisiones.service.DecisionService
import org.cr_d.decisiones.usecases.CreateDecisionUseCase
import org.cr_d.decisiones.usecases.GetAllOptionsByDecisionUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(value = ["/decisions"])
class DecisionController (
    private val decisionService: DecisionService,
    private val createDecision: CreateDecisionUseCase,
    private val getAllOptionsByDecision: GetAllOptionsByDecisionUseCase
) {
    @GetMapping(value = [""])
    fun getAll(model: Model): String{
        model.addAttribute("title", "Listado de decisiones")
        model.addAttribute("decisions", decisionService.findAll())

        return "decision/list"
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long, model: Model): String {
        val decision = decisionService.findById(id) ?: return "redirect:/decision/error"
        val decisionOptions = getAllOptionsByDecision.execute(decision)

        model.addAttribute("title", "Información de la decisión")
        model.addAttribute("decision", decision)
        model.addAttribute("options", decisionOptions)

        return "decision/detail"
    }

    @GetMapping("/new")
    fun create(model: Model): String {
        val emptyDecision = DecisionRequest(null, "")
        model.addAttribute("decision", emptyDecision)
        model.addAttribute("title", "Crear Decisión")

        return "decision/form"
    }

    @PostMapping("")
    fun save(@ModelAttribute decision : DecisionRequest): String {
        val decision = createDecision.execute(decision)

        decisionService.save(decision)

        return "redirect:/decisions"
    }


}