package fr.neobagram.thesoreloser.domain.usecase

import fr.neobagram.thesoreloser.domain.model.PlayerDTO
import fr.neobagram.thesoreloser.domain.repository.PlayerRepository
import javax.inject.Inject

class GetAllPlayersUseCase @Inject constructor(private val playerRepository: PlayerRepository) {

    suspend operator fun invoke(): List<PlayerDTO> {
        return playerRepository.getAllPlayers()
    }
}