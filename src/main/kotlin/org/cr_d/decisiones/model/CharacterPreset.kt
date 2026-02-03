package org.cr_d.decisiones.model

import jakarta.persistence.*

@Entity
@Table(name = "character_presets")
data class CharacterPreset (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    val race: String,
    @Column(nullable = false)
    val sex: String,
    @Column(nullable = false)
    val description: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initial_location", nullable = false)
    val location: Location,
)