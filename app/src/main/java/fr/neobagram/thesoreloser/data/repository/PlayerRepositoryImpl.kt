package fr.neobagram.thesoreloser.data.repository

import fr.neobagram.thesoreloser.data.local.dao.PlayerDao
import fr.neobagram.thesoreloser.data.mapper.toDTO
import fr.neobagram.thesoreloser.data.mapper.toDb
import fr.neobagram.thesoreloser.domain.model.PlayerDTO
import fr.neobagram.thesoreloser.domain.repository.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(private val playerDao: PlayerDao): PlayerRepository {
    override suspend fun createPlayer(newPlayer: PlayerDTO) {
        withContext(Dispatchers.IO) {
            playerDao.insertPlayer(newPlayer.toDb())
        }
    }

    override suspend fun getAllPlayers(): List<PlayerDTO> {
        return withContext(Dispatchers.IO) {
            playerDao.getAllPlayers().map { it.toDTO() }
        }
    }

    /*
    override suspend fun getPlayersByPartyId(partyId: Int): List<PlayerDTO> {
        return withContext(Dispatchers.IO) {
            playerDao.getPlayersByPartyId(partyId).map { it.toDTO() }
        }
    }

     */
}
