package org.cr_d.decisiones.controller

import org.springframework.web.bind.annotation.*

import org.cr_d.decisiones.dto.LocationResponse
import org.cr_d.decisiones.dto.LocationRestResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.mapper.toRestResponse
import org.cr_d.decisiones.service.LocationService
import org.cr_d.decisiones.usecase.GetAllNpcsByLocationUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/locations")
class LocationRestController (
    private val locationService: LocationService,
    private val getNpcs: GetAllNpcsByLocationUseCase
){
    @GetMapping("")
    fun getLocations(): List<LocationResponse>{
        return locationService.getAllLocations().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getLocationById(@PathVariable id : Long): LocationRestResponse? {
        val location = locationService.getLocationById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found")
        val npcs = getNpcs.execute(location).map { it.toResponse() }

        return location.toRestResponse(npcs)
    }
}