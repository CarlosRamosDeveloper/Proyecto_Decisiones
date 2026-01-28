package org.cr_d.decisiones.repository

import org.cr_d.decisiones.model.CharacterPreset
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CharacterPresetRepository : JpaRepository<CharacterPreset, Long>