package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.NpcResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.NpcService
import org.springframework.web.bind.annotation.*

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
        val npc = npcService.findById(id)

        if (npc != null) return npc.toResponse()

        return null
    }
}
