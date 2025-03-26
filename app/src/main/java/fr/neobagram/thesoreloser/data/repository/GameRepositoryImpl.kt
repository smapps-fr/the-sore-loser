package fr.neobagram.thesoreloser.data.repository

import fr.neobagram.thesoreloser.data.local.dao.GameDao
import fr.neobagram.thesoreloser.data.mapper.toDTO
import fr.neobagram.thesoreloser.data.mapper.toDb
import fr.neobagram.thesoreloser.domain.model.GameDTO
import fr.neobagram.thesoreloser.domain.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(private val gameDao: GameDao): GameRepository {

    override suspend fun getAllGames(): List<GameDTO> {
        return withContext(Dispatchers.IO) {
            gameDao.getAllGames().map { it.toDTO() }
        }
    }
}