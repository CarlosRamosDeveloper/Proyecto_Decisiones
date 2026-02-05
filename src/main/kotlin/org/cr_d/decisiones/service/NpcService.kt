package org.cr_d.decisiones.service

import org.cr_d.decisiones.model.NonPlayableCharacter
import org.cr_d.decisiones.repository.NpcRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class NpcService(
    private val npcRepository: NpcRepository
) {
    fun findAll(): List<NonPlayableCharacter> = npcRepository.findAll()
    fun findById(id: Long) = npcRepository.findByIdOrNull(id)
    fun findByLocationId(locationId: Long) = npcRepository.findByLocationId(locationId)
    fun save(npc: NonPlayableCharacter) = npcRepository.save(npc)
    fun deleteById(id: Long) = npcRepository.deleteById(id)
}