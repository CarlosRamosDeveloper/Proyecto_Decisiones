package org.cr_d.decisiones.usecase

import org.springframework.stereotype.Service

import org.cr_d.decisiones.dto.NpcRequest
import org.cr_d.decisiones.model.NonPlayableCharacter
import org.cr_d.decisiones.service.CharacterPresetService
import org.cr_d.decisiones.service.LocationService

@Service
class CreateNpcUseCase (
    private val presetService: CharacterPresetService,
    private val locationService: LocationService,
){
    fun execute(npc: NpcRequest, id: Long? = null) : NonPlayableCharacter{
        val preset = presetService.getPresetById(npc.presetId) ?: throw RuntimeException("Preset no encontrado")
        val location = locationService.getLocationById(npc.locationId) ?: throw RuntimeException("Location no encontrado")

        return NonPlayableCharacter(
            id = id,
            preset = preset,
            name = npc.name,
            location = location,
            description = npc.description
        )
    }
}