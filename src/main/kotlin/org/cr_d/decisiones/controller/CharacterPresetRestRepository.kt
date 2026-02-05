package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.CharacterPresetResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.CharacterPresetService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/presets")
class CharacterPresetRestRepository (
    private val characterPresetService: CharacterPresetService,
){
    @GetMapping("")
    fun getPresets() : List<CharacterPresetResponse?>{
        return characterPresetService.getAllPresets().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getPreset(@PathVariable id : Long) : CharacterPresetResponse?{
        return characterPresetService.getPresetById(id)?.toResponse()
    }
}