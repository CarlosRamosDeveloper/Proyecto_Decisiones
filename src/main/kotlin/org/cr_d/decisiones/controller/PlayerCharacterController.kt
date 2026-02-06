package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.CharacterRequest
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.CharacterPresetService
import org.cr_d.decisiones.service.PlayerCharacterService
import org.cr_d.decisiones.service.UserService
import org.cr_d.decisiones.usecases.CreateCharacterUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/characters")
class PlayerCharacterController (
    private val characterService: PlayerCharacterService,
    private val usersService: UserService,
    private val presetService: CharacterPresetService,
    private val createCharacter: CreateCharacterUseCase

){
    @GetMapping("")
    fun getCharacters(model: Model): String{
        model.addAttribute("characters", characterService.getAllCharacters().map { it.toResponse() })
        model.addAttribute("title", "Listado de Personajes")
        model.addAttribute("users", usersService.getAllUsers().count())

        return "character/list"
    }

    @GetMapping("/{id}")
    fun getCharacterById(@PathVariable id: Long, model: Model): String {
        val character = characterService.getCharacterById(id) ?: return "redirect:/character/error"
        model.addAttribute("title", "Listado de personajes")
        model.addAttribute("character", character.toResponse())

        return "character/detail"
    }

    @GetMapping("/new")
    fun createCharacter(model: Model): String {
        val emptyCharacter = CharacterRequest(null, 0, 0, "")
        model.addAttribute("character", emptyCharacter)
        model.addAttribute("users", usersService.getAllUsers())
        model.addAttribute("presets", presetService.getAllPresets())
        model.addAttribute("title", "Crear Personaje")

        return "character/form"
    }

    @PostMapping("")
    fun saveCharacter(@ModelAttribute character : CharacterRequest): String {
        val newCharacter = createCharacter.execute(character)

        characterService.save(newCharacter)

        return "redirect:/characters"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val character = characterService.getCharacterById(id) ?: return "redirect:/character/error"
        model.addAttribute("character", character)
        model.addAttribute("users", usersService.getAllUsers())
        model.addAttribute("presets", presetService.getAllPresets())
        model.addAttribute("title", "Actualizar Usuario")

        return "character/form"
    }

    @PostMapping("/update/{id}")
    fun updateCharacter(@PathVariable id: Long, @ModelAttribute character: CharacterRequest): String {
        val characterToUpdate = createCharacter.execute(character, id)

        characterService.save(characterToUpdate)

        return "redirect:/characters"
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String {
        characterService.deleteById(id)

        return "redirect:/characters"
    }

    @GetMapping("/error")
    fun characterError(): String {
        return "character/error"
    }
}