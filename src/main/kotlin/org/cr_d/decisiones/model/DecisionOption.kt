package org.cr_d.decisiones.model

import jakarta.persistence.*

@Entity
@Table(
    name = "decision_options",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["decision_id", "option_key"])
    ]
)
data class DecisionOption(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_id", nullable = false)
    val decision: Decision,

    @Column(name = "option_key", nullable = false)
    val key: String,

    val text: String? = null
)