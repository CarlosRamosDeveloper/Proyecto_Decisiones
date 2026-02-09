package org.cr_d.decisiones.controller

import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.NpcResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.NpcService
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/npcs")
class NpcRestController (
    private val npcService: NpcService,
){
    @GetMapping("")
    fun getNpcList() : List<NpcResponse>{
        return npcService.findAll().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getNpcById(@PathVariable id : Long) : NpcResponse? {
        val npc = npcService.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "NPC not found")

        return npc.toResponse()
    }
}
