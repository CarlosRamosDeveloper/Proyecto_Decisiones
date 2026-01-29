package org.cr_d.decisiones.controller

import org.cr_d.decisiones.model.Location
import org.cr_d.decisiones.service.LocationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/locations")
class LocationRestController (
    private val locationService: LocationService
){
    @GetMapping("")
    fun getLocations(): List<Location>{
        return locationService.getAllLocations()
    }

    @GetMapping("/{id}")
    fun getLocationById(@PathVariable("id") id : Long): Location? {
        return locationService.getLocationById(id)
    }

    //TODO: Eliminar del rest controller cuando esté corriendo el modo admin
    @PostMapping("")
    fun createLocation(@RequestBody location: Location){
        locationService.save(location)
    }
}