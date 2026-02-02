package org.cr_d.decisiones.controller

import org.cr_d.decisiones.service.NpcService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/npcs")
class NpcController (
    private val npcService: NpcService
){
    @GetMapping("")
    fun getNpcList(model: Model): String{
        model.addAttribute("npcs", npcService.findAll())
        model.addAttribute("title", "Listado de NPCs")

        return "npc/list"
    }


}