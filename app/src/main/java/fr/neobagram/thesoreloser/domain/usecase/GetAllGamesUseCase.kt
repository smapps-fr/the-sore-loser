package fr.neobagram.thesoreloser.domain.usecase

import fr.neobagram.thesoreloser.domain.model.GameDTO
import fr.neobagram.thesoreloser.domain.repository.GameRepository
import javax.inject.Inject

class GetAllGamesUseCase @Inject constructor(private val gameRepository: GameRepository) {

    suspend operator fun invoke(): List<GameDTO> {
        return gameRepository.getAllGames()
    }
}