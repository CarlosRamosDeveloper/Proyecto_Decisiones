package org.cr_d.decisiones.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

import org.cr_d.decisiones.model.Location
import org.cr_d.decisiones.repository.LocationRepository

@Service
class LocationService (
    private val locationRepository: LocationRepository
){
    fun getAllLocations(): List<Location> = locationRepository.findAll()
    fun getLocationById(id: Long): Location? = locationRepository.findByIdOrNull(id)
    fun save(location: Location): Location = locationRepository.save(location)
}