package org.cr_d.decisiones.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "player_decisions",
        uniqueConstraints = [
            UniqueConstraint(
                columnNames = ["player_character_id", "decision_id"]
            )
        ]
)
class PlayerDecision(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val playerCharacter: PlayerCharacter,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_id", nullable = false)
    val decision: Decision,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_option_id", nullable = false)
    val decisionOption: DecisionOption,
    val createdAt: LocalDateTime = LocalDateTime.now()
)