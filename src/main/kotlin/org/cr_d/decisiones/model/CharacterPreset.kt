package org.cr_d.decisiones.model

import jakarta.persistence.*

@Entity
@Table(name = "character_presets")
data class CharacterPreset (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(nullable = false)
    var race: String
)