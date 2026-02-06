package org.cr_d.decisiones.model

import jakarta.persistence.*

@Entity
@Table(name = "decisions")
data class Decision(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "decision_key", unique = true, nullable = false)
    val key: String,

    val description: String? = null
)