package org.cr_d.decisiones.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import org.cr_d.decisiones.model.Location

@Repository
interface LocationRepository : JpaRepository <Location, Long>