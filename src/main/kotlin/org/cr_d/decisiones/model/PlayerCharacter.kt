package org.cr_d.decisiones.model

import jakarta.persistence.*

@Entity
@Table(name = "player_characters")
class PlayerCharacter (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    val userId: User,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preset_id", nullable = false)
    val presetId: CharacterPreset,
    val name: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_location_id", nullable = false)
    val lastLocationId: Location,
)