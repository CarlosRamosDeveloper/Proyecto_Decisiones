package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.NpcRequest
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.CharacterPresetService
import org.cr_d.decisiones.service.LocationService
import org.cr_d.decisiones.service.NpcService
import org.cr_d.decisiones.usecases.CreateNpcUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/npcs")
class NpcController (
    private val npcService: NpcService,
    private val locationService: LocationService,
    private val presetService: CharacterPresetService,
    private val createNpc: CreateNpcUseCase
){
    @GetMapping("")
    fun getNpcList(model: Model): String{
        model.addAttribute("npcs", npcService.findAll())
        model.addAttribute("title", "Listado de NPCs")

        return "npc/list"
    }

    @GetMapping("/{id}")
    fun getNpcById(@PathVariable id: Long, model: Model): String {
        val npc = npcService.findById(id).toResponse()
        model.addAttribute("title", "Listado de Usuarios")
        model.addAttribute("npc", npc)

        return "npc/detail"
    }

    @GetMapping("/new")
    fun createNpc(model: Model): String {
        val emptyNpc = NpcRequest(null, 0, "", 0, "")
        model.addAttribute("npc", emptyNpc)
        model.addAttribute("locations", locationService.getAllLocations())
        model.addAttribute("presets", presetService.getAllPresets())
        model.addAttribute("title", "Crear NPC")

        return "npc/form"
    }

    @PostMapping("")
    fun saveNpc(@ModelAttribute npc : NpcRequest): String {
        val newNpc = createNpc.execute(npc)
        npcService.save(newNpc)

        return "redirect:/npcs"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val npc = npcService.findById(id)
        val npcToUpdate = NpcRequest(id, npc.preset.id!!, npc.name, npc.location.id!!, npc.description)

        model.addAttribute("npc", npcToUpdate)
        model.addAttribute("locations", locationService.getAllLocations())
        model.addAttribute("presets", presetService.getAllPresets())
        model.addAttribute("title", "Actualizar NPC")

        return "npc/form"
    }

    @PostMapping("/update/{id}")
    fun updateNpc(@PathVariable id: Long, @ModelAttribute npc: NpcRequest): String {
        val updatedNpc = createNpc.execute(npc, id)
        npcService.save(updatedNpc)

        return "redirect:/npcs"
    }

    @GetMapping("/delete/{id}")
    fun deleteNpc(@PathVariable id: Long): String {
        npcService.deleteById(id)

        return "redirect:/npcs"
    }
}