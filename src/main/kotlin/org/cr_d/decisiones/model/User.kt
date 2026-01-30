package org.cr_d.decisiones.model

import jakarta.persistence.*
import java.util.Collections.emptyList

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(unique = true, nullable = false)
    val username: String,
    @Column(unique = true, nullable = false)
    val email: String,
    @OneToMany(
        mappedBy = "userId",
        cascade = [CascadeType.REMOVE],
        orphanRemoval = true
    )
    val characters: MutableList<PlayerCharacter> = emptyList()
)
