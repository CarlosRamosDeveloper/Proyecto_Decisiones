package org.cr_d.decisiones.model

import jakarta.persistence.*

@Entity
@Table(name = "character_preset")
data class CharacterPreset (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var race: String? = null,
)