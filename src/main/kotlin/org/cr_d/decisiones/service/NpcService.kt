package org.cr_d.decisiones.service

import org.cr_d.decisiones.model.NonPlayableCharacter
import org.cr_d.decisiones.repository.NpcRepository

class NpcService(
    private val npcRepository: NpcRepository
) {
    fun findAll() = npcRepository.findAll()
    fun findById(id: Long) = npcRepository.findById(id)
    fun save(npc: NonPlayableCharacter) = npcRepository.save(npc)
    fun deleteById(id: Long) = npcRepository.deleteById(id)
}