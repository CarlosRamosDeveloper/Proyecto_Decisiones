package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.CharacterPresetRequest
import org.cr_d.decisiones.dto.UserRequest
import org.cr_d.decisiones.model.CharacterPreset
import org.cr_d.decisiones.model.User
import org.cr_d.decisiones.service.CharacterPresetService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/presets")
class CharacterPresetController (
    private val characterPresetService: CharacterPresetService
){
    @GetMapping("")
    fun getPresets(model: Model): String{
        model.addAttribute("presets",characterPresetService.getAllPresets())
        model.addAttribute("title", "Listado de Presets")

        return "preset/list"
    }

    @GetMapping("/{id}")
    fun getPresetById(@PathVariable id: Long, model: Model): String {
        val preset = characterPresetService.getPresetById(id) ?: return "redirect:/user/error"
        model.addAttribute("title", "Listado de Presets")
        model.addAttribute("preset", preset)

        return "preset/detail"
    }

    @GetMapping("/new")
    fun createPreset(model: Model): String {
        val emptyPreset = CharacterPresetRequest(0,"", "", 0, "")
        model.addAttribute("preset", emptyPreset)
        model.addAttribute("title", "Crear Preset")

        return "preset/form"
    }

    @PostMapping("")
    fun savePreset(@ModelAttribute preset : CharacterPreset): String {
        characterPresetService.save(preset)

        return "redirect:/presets"
    }

    @GetMapping("/error")
    fun userError(): String {
        return "preset/error"
    }
}