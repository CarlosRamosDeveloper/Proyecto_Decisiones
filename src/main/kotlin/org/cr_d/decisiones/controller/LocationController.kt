package org.cr_d.decisiones.controller

import org.cr_d.decisiones.model.Location
import org.cr_d.decisiones.model.NonPlayableCharacter
import org.cr_d.decisiones.service.LocationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/locations")
class LocationController(
    private val locationService: LocationService
) {
    @GetMapping("")
    fun getLocations(model: Model): String {
        model.addAttribute("title", "Ubicaciones")
        model.addAttribute("locations", locationService.getAllLocations())

        return "location/list"
    }

    @GetMapping("/{id}")
    fun getPresetById(@PathVariable id: Long, model: Model): String {
        val location = locationService.getLocationById(id) ?: return "redirect:/preset/error"
        val relatedNpcs = emptyList<NonPlayableCharacter>()
        model.addAttribute("title", "Información de Ubicación")
        model.addAttribute("location", location)
        model.addAttribute("relatedNpcs", relatedNpcs)

        return "location/detail"
    }

    //TODO: Eliminar del rest controller cuando esté corriendo el modo admin
    @PostMapping("")
    fun createLocation(@RequestBody location: Location) {
        locationService.save(location)
    }

    @GetMapping("/error")
    fun userError(): String {
        return "location/error"
    }
}