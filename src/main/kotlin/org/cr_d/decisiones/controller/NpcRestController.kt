package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.NpcRequest
import org.cr_d.decisiones.model.NonPlayableCharacter
import org.cr_d.decisiones.service.NpcService
import org.cr_d.decisiones.usecases.CreateNpcUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/npcs")
class NpcRestController (
    private val npcService: NpcService,
    private val create: CreateNpcUseCase
){
    @GetMapping("")
    fun getNpcs() : List<NonPlayableCharacter>{
        return npcService.findAll()
    }

    @GetMapping("/{id}")
    fun getNpcById(@PathVariable("id") id : Long) : NonPlayableCharacter{
        return npcService.findById(id)
    }

    @PostMapping("")
    fun createNpc(@RequestBody npc: NpcRequest) : NonPlayableCharacter{
        val newNpc = create.execute(npc)

        return npcService.save(newNpc)
    }
}