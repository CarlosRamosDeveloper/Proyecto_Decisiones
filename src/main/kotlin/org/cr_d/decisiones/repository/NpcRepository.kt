package org.cr_d.decisiones.repository

import org.cr_d.decisiones.model.NonPlayableCharacter
import org.springframework.data.jpa.repository.JpaRepository

interface NpcRepository : JpaRepository<NonPlayableCharacter, Long>