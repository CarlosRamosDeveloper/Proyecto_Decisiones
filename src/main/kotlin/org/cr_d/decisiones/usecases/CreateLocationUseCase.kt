package org.cr_d.decisiones.usecases

import org.springframework.stereotype.Service

import org.cr_d.decisiones.dto.LocationRequest
import org.cr_d.decisiones.model.Location

@Service
class CreateLocationUseCase {
    fun execute(location: LocationRequest, id: Long? = null): Location {
        return Location(
            id = id,
            name = location.name,
            description = location.description,
        )
    }
}