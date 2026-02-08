package org.cr_d.decisiones.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

import org.cr_d.decisiones.model.CharacterPreset
import org.cr_d.decisiones.repository.CharacterPresetRepository

@Service
class CharacterPresetService (
    private val presetRepository: CharacterPresetRepository
) {
    fun getAllPresets(): List<CharacterPreset> = presetRepository.findAll()
    fun getPresetById(id: Long): CharacterPreset? = presetRepository.findByIdOrNull(id)
    fun save(characterPreset: CharacterPreset): CharacterPreset = presetRepository.save(characterPreset)
    fun deleteById(id: Long) = presetRepository.deleteById(id)
}