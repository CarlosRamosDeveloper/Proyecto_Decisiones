package org.cr_d.decisiones.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

import org.cr_d.decisiones.model.PlayerCharacter
import org.cr_d.decisiones.model.User
import org.cr_d.decisiones.repository.PlayerCharacterRepository

@Service
class PlayerCharacterService(
    private val characterRepository: PlayerCharacterRepository
){
    fun getAllCharacters(): List<PlayerCharacter> = characterRepository.findAll()
    fun getAllCharactersByUser(user: User) : List<PlayerCharacter> = characterRepository.findAllByUserId(user)
    fun getCharacterById(id : Long) : PlayerCharacter? = characterRepository.findByIdOrNull(id)
    fun save(playerCharacter : PlayerCharacter) : PlayerCharacter = characterRepository.save(playerCharacter)
    fun deleteById(id: Long) = characterRepository.deleteById(id)
    fun count(): Long = characterRepository.count()
}