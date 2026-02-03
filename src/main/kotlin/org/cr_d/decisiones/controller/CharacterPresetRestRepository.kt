package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.CharacterPresetRequest
import org.cr_d.decisiones.model.CharacterPreset
import org.cr_d.decisiones.service.CharacterPresetService
import org.cr_d.decisiones.service.LocationService
import org.cr_d.decisiones.usecases.CreateCharacterPreset
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/presets")
class CharacterPresetRestRepository (
    private val characterPresetService: CharacterPresetService,
    private val createCharacterPreset: CreateCharacterPreset
){
    @GetMapping("")
    fun getPresets() : List<CharacterPreset>{
        return characterPresetService.getAllPresets()
    }

    @GetMapping("/{id}")
    fun getPreset(@PathVariable("id") id : Long) : CharacterPreset?{
        return characterPresetService.getPresetById(id)
    }

    //TODO: Eliminar del rest controller cuando esté corriendo el modo admin
    @PostMapping("")
    fun createLocation(@RequestBody preset: CharacterPresetRequest){
        val newPreset = createCharacterPreset.execute(preset)

        if (newPreset != null) characterPresetService.save(newPreset)
    }
}