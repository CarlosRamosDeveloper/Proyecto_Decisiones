package org.cr_d.decisiones.repository

import org.cr_d.decisiones.model.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationRepository : JpaRepository <Location, Long>