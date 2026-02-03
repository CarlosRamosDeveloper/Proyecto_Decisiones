package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.LocationResponse
import org.cr_d.decisiones.model.Location

fun Location.toResponse(): LocationResponse {
    return LocationResponse(
        id!!, name, description
    )
}