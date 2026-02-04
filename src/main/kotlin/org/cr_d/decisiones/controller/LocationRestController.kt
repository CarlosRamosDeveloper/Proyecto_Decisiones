package org.cr_d.decisiones.controller

import org.cr_d.decisiones.dto.LocationResponse
import org.cr_d.decisiones.mapper.toResponse
import org.cr_d.decisiones.service.LocationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/locations")
class LocationRestController (
    private val locationService: LocationService,
){
    @GetMapping("")
    fun getLocations(): List<LocationResponse>{
        return locationService.getAllLocations().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getLocationById(@PathVariable id : Long): LocationResponse? {
        val location = locationService.getLocationById(id)

        if(location != null) return location.toResponse()

        return null
    }
}