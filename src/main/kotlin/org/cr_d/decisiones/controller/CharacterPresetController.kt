package org.cr_d.decisiones.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.CharacterPresetRequest
import org.cr_d.decisiones.service.CharacterPresetService
import org.cr_d.decisiones.service.LocationService
import org.cr_d.decisiones.usecases.CreateCharacterPresetUseCase

@Controller
@RequestMapping("/presets")
class CharacterPresetController (
    private val characterPresetService: CharacterPresetService,
    private val locationService: LocationService,
    private val createPreset: CreateCharacterPresetUseCase
){
    @GetMapping("")
    fun getPresets(model: Model): String{
        model.addAttribute("presets",characterPresetService.getAllPresets())
        model.addAttribute("title", "Listado de Presets")

        return "preset/list"
    }

    @GetMapping("/{id}")
    fun getPresetById(@PathVariable id: Long, model: Model): String {
        val preset = characterPresetService.getPresetById(id) ?: return "redirect:/presets/error"
        model.addAttribute("title", "Información del preset")
        model.addAttribute("preset", preset)

        return "preset/detail"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val preset = characterPresetService.getPresetById(id) ?: return "redirect:/presets/error"
        val presetToUpdate = CharacterPresetRequest(preset.id,preset.race, preset.sex, preset.location.id!!, preset.description)

        model.addAttribute("preset", presetToUpdate)
        model.addAttribute("locations", locationService.getAllLocations())
        model.addAttribute("title", "Actualizar Usuario")

        return "preset/form"
    }

    @PostMapping("/update/{id}")
    fun updatePreset(@PathVariable id: Long, @ModelAttribute preset : CharacterPresetRequest): String {
        val updatedPreset = createPreset.execute(preset, id) ?: return "redirect:/presets/error"

        characterPresetService.save(updatedPreset)

        return "redirect:/presets"
    }

    @GetMapping("/error")
    fun userError(): String {
        return "preset/error"
    }
}