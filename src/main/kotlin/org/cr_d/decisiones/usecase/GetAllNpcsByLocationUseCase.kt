package org.cr_d.decisiones.usecase

import org.springframework.stereotype.Service

import org.cr_d.decisiones.model.Location
import org.cr_d.decisiones.model.NonPlayableCharacter
import org.cr_d.decisiones.service.NpcService

@Service
class GetAllNpcsByLocationUseCase (
    private val npcService: NpcService
){
    fun execute(location: Location): List<NonPlayableCharacter> {
        return npcService.findByLocationId(location.id!!)
    }
}