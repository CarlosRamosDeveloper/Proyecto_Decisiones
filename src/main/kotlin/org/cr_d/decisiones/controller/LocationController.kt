package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.LocationRequest
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.LocationService
import org.cr_d.decisiones.usecases.CreateLocationUseCase
import org.cr_d.decisiones.usecases.GetAllNpcsByLocationUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/locations")
class LocationController(
    private val locationService: LocationService,
    private val createLocation: CreateLocationUseCase,
    private val getNpcs: GetAllNpcsByLocationUseCase
) {
    @GetMapping("")
    fun getLocations(model: Model): String {
        model.addAttribute("title", "Ubicaciones")
        model.addAttribute("locations", locationService.getAllLocations())

        return "location/list"
    }

    @GetMapping("/{id}")
    fun getPresetById(@PathVariable id: Long, model: Model): String {
        val location = locationService.getLocationById(id) ?: return "redirect:/locations/error"
        val relatedNpcs = getNpcs.execute(location).map { it.toResponse() }
        model.addAttribute("title", "Información de Ubicación")
        model.addAttribute("location", location)
        model.addAttribute("relatedNpcs", relatedNpcs)

        return "location/detail"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val location = locationService.getLocationById(id) ?: return "redirect:/locations/error"
        val updatedLocation = LocationRequest(id, location.name, location.description)
        model.addAttribute("location", updatedLocation)
        model.addAttribute("title", "Actualizar ubicación")

        return "location/form"
    }

    @PostMapping("/update/{id}")
    fun updatePreset(@PathVariable id: Long, @ModelAttribute location : LocationRequest): String {
        val updatedLocation = createLocation.execute(location, id)
        locationService.save(updatedLocation)

        return "redirect:/locations"
    }

    @GetMapping("/error")
    fun userError(): String {
        return "location/error"
    }
}