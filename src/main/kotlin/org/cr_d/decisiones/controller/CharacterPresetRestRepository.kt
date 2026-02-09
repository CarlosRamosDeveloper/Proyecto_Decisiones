package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.CharacterPresetResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.CharacterPresetService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

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
        val response = characterPresetService.getPresetById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Preset not found")

        return response.toResponse()
    }
}