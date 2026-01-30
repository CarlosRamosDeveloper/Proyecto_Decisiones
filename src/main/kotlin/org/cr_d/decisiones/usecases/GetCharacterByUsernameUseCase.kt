package org.cr_d.decisiones.usecases

import org.cr_d.decisiones.model.PlayerCharacter
import org.cr_d.decisiones.service.PlayerCharacterService
import org.cr_d.decisiones.service.UserService
import org.springframework.stereotype.Service

@Service
class GetCharacterByUsernameUseCase (
    private val userService: UserService,
    private val characterService: PlayerCharacterService,
) {
    fun execute(userId: Long) : List<PlayerCharacter> {
        val user = userService.getUserById(userId)?: throw RuntimeException("Usuario no encontrado")

        return characterService.getAllCharactersByUser(user)
    }
}