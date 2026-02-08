package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.PlayerDecisionRequest
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.DecisionOptionService
import org.cr_d.decisiones.service.DecisionService
import org.cr_d.decisiones.service.PlayerCharacterService
import org.cr_d.decisiones.service.PlayerDecisionService
import org.cr_d.decisiones.usecases.CreatePlayerDecisionUseCase
import org.cr_d.decisiones.usecases.UpdatePlayerDecisionUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


// TODO: Mostrar errores en asignación
@Controller
@RequestMapping("/playerDecisions")
class PlayerDecisionController (
    private val playerDecisionService: PlayerDecisionService,
    private val create: CreatePlayerDecisionUseCase,
    private val update: UpdatePlayerDecisionUseCase,
    private val characterService: PlayerCharacterService,
    private val decisionService: DecisionService,
    private val decisionOptionService: DecisionOptionService
){
    @GetMapping("")
    fun getAll(model: Model): String {
        val totalCharacters = characterService.count().toInt()
        val totalDecisions = decisionService.count().toInt()
        val totalOptions = decisionOptionService.count().toInt()
        val missing = mutableListOf<String>()

        if (totalCharacters == 0) missing += "personajes"
        if (totalDecisions == 0) missing += "decisiones"
        if (totalOptions == 0) missing += "opciones"

        val errorMessage = if (missing.isNotEmpty()) {
            "No se pueden asociar decisiones si no hay ${missing.joinToString(", ")} en el sistema."
        } else null

        val canCreate = totalCharacters > 0 && totalDecisions > 0 && totalOptions > 0

        model.addAttribute("title","Lista de decisiones de personaje")
        model.addAttribute("is_button_enabled",canCreate)
        model.addAttribute("error_message",errorMessage)
        model.addAttribute("player_decisions", playerDecisionService.findAll().map{ it.toResponse() })

        return "player_decision/list"
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long, model: Model): String {
        val playerDecision = playerDecisionService.findById(id)?.toResponse()

        model.addAttribute("title", "Información de la decisión")
        model.addAttribute("decision", playerDecision)

        return "player_decision/detail"
    }

    @GetMapping("/new")
    fun create(model: Model): String {
        val emptyPlayerDecision = PlayerDecisionRequest(null, 0, 0,0)
        model.addAttribute("player_decision", emptyPlayerDecision)
        model.addAttribute("characters", characterService.getAllCharacters())
        model.addAttribute("decisions", decisionService.findAll())
        model.addAttribute("options", decisionOptionService.findAll())
        model.addAttribute("title", "Asignar decisión a personaje")

        return "player_decision/form"
    }

    @PostMapping("")
    fun save(@ModelAttribute decision : PlayerDecisionRequest): String {
        val decision = create.execute(decision)

        playerDecisionService.save(decision)

        return "redirect:/playerDecisions"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val playerDecision = playerDecisionService.findById(id)
        val playerDecisionToUpdate = PlayerDecisionRequest(
            id = id,
            characterId = playerDecision!!.playerCharacter.id!!,
            decisionId = playerDecision.decision.id!!,
            optionId = playerDecision.decisionOption.id!!,
        )

        model.addAttribute("player_decision", playerDecisionToUpdate)
        model.addAttribute("characters", characterService.getAllCharacters())
        model.addAttribute("decisions", decisionService.findAll())
        model.addAttribute("options", decisionOptionService.findAll())
        model.addAttribute("title", "Modificar decisión de personaje")

        return "player_decision/form"
    }

    @PostMapping("/update/{id}")
    fun update(@PathVariable id: Long, @ModelAttribute decision: PlayerDecisionRequest): String {
        val updatedDecision = update.execute(decision, id)
        playerDecisionService.save(updatedDecision)

        return "redirect:/playerDecisions"
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String {
        playerDecisionService.delete(id)

        return "redirect:/playerDecisions"
    }

}