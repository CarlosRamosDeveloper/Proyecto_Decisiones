package org.cr_d.decisiones.repository

import org.springframework.data.jpa.repository.JpaRepository

import org.cr_d.decisiones.model.NonPlayableCharacter

interface NpcRepository : JpaRepository<NonPlayableCharacter, Long> {
    fun findByLocationId(locationId: Long): List<NonPlayableCharacter>
}