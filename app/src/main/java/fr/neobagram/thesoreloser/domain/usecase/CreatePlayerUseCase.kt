package fr.neobagram.thesoreloser.domain.usecase

import fr.neobagram.thesoreloser.domain.model.PlayerDTO
import fr.neobagram.thesoreloser.domain.repository.PlayerRepository
import javax.inject.Inject

class CreatePlayerUseCase @Inject constructor(private val playerRepository: PlayerRepository) {

    suspend operator fun invoke(playerDTO: PlayerDTO) {
        playerRepository.createPlayer(playerDTO)
    }

}