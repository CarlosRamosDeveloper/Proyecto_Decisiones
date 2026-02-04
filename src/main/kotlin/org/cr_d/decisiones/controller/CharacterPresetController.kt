package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.CharacterPresetRequest
import org.cr_d.decisiones.model.User
import org.cr_d.decisiones.service.CharacterPresetService
import org.cr_d.decisiones.service.LocationService
import org.cr_d.decisiones.usecases.CreateCharacterPresetUseCase
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
        val preset = characterPresetService.getPresetById(id) ?: return "redirect:/preset/error"
        model.addAttribute("title", "Información del preset")
        model.addAttribute("preset", preset)

        return "preset/detail"
    }
    // TODO: Eliminar antes de entregar
    @GetMapping("/new")
    fun createPreset(model: Model): String {
        val emptyPreset = CharacterPresetRequest(null,"", "", 1, "")
        model.addAttribute("preset", emptyPreset)
        model.addAttribute("locations", locationService.getAllLocations())
        model.addAttribute("title", "Crear Preset")

        return "preset/form"
    }

    // TODO: Eliminar antes de entregar
    @PostMapping("")
    fun savePreset(@ModelAttribute preset : CharacterPresetRequest): String {
        val newPreset = createPreset.execute(preset)

        if (newPreset != null) characterPresetService.save(newPreset)

        return "redirect:/presets"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable("id") id: Long, model: Model): String {
        val preset = characterPresetService.getPresetById(id) ?: return "redirect:/preset/error"
        val presetToUpdate = CharacterPresetRequest(preset.id,preset.race, preset.sex, preset.location.id!!, preset.description)
        model.addAttribute("preset", presetToUpdate)
        model.addAttribute("locations", locationService.getAllLocations())
        model.addAttribute("title", "Actualizar Usuario")

        return "preset/form"
    }

    @PostMapping("/update/{id}")
    fun updatePreset(@PathVariable id: Long, @ModelAttribute preset : CharacterPresetRequest): String {
        val updatedPreset = createPreset.execute(preset, id)

        if (updatedPreset != null ) characterPresetService.save(updatedPreset)

        return "redirect:/presets"
    }
    // TODO: Eliminar antes de entregar
    @GetMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): String {
        characterPresetService.deleteById(id)
        return "redirect:/presets"
    }

    @GetMapping("/error")
    fun userError(): String {
        return "preset/error"
    }
}