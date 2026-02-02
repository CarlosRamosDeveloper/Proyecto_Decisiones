package org.cr_d.decisiones.controller

import org.cr_d.decisiones.repository.CharacterPresetRepository
import org.cr_d.decisiones.service.CharacterPresetService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/presets")
class CharacterPresetController (
    private val characterPresetService: CharacterPresetService
){
    @GetMapping("")
    fun getPresets(model: Model): String{
        model.addAttribute("presets", characterPresetService.getAllPresets())
        model.addAttribute("title", "Listado de Presets")

        return "preset/list"
    }
}