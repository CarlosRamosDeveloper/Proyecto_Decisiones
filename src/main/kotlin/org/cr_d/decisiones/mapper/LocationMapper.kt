package org.cr_d.decisiones.mapper

import org.cr_d.decisiones.dto.LocationResponse
import org.cr_d.decisiones.dto.LocationRestResponse
import org.cr_d.decisiones.dto.NpcResponse
import org.cr_d.decisiones.model.Location

fun Location.toResponse(): LocationResponse {
    return LocationResponse(
        id = id!!,
        name = name,
        description = description
    )
}

fun Location.toRestResponse(npcs: List<NpcResponse>): LocationRestResponse {
    return LocationRestResponse(
        id = id!!,
        name = name,
        description = description,
        npcs = npcs
    )
}