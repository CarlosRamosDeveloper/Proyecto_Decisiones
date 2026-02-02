package org.cr_d.decisiones.controller

import org.cr_d.decisiones.service.PlayerCharacterService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/characters")
class PlayerCharacterController (
    private val characterService: PlayerCharacterService,
){
    @GetMapping("")
    fun getCharacters(model: Model): String{
        model.addAttribute("characters", characterService.getAllCharacters())
        model.addAttribute("title", "Listado de Personajes")

        return "character/list"
    }
}