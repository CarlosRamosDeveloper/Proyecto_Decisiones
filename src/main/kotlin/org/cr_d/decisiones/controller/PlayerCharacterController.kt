package org.cr_d.decisiones.controller

import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.PlayerCharacterService
import org.cr_d.decisiones.usecases.GetUsersCountUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/characters")
class PlayerCharacterController (
    private val characterService: PlayerCharacterService,
    private val getUsers: GetUsersCountUseCase
){
    // TODO: No habilitar el botón de crear si no hay usuarios
    @GetMapping("")
    fun getCharacters(model: Model): String{
        model.addAttribute("characters", characterService.getAllCharacters().map { it.toResponse() })
        model.addAttribute("title", "Listado de Personajes")
        model.addAttribute("users", getUsers.execute())

        return "character/list"
    }

    @GetMapping("/{id}")
    fun getCharacterById(@PathVariable id: Long, model: Model): String {
        val character = characterService.getCharacterById(id) ?: return "redirect:/character/error"
        model.addAttribute("title", "Listado de personajes")
        model.addAttribute("character", character.toResponse())

        return "character/detail"
    }
}