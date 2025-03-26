package fr.neobagram.thesoreloser.domain.repository

import fr.neobagram.thesoreloser.domain.model.PlayerDTO

interface PlayerRepository {

    suspend fun createPlayer(newPlayerDTO: PlayerDTO)
    suspend fun getAllPlayers(): List<PlayerDTO>
    //suspend fun getPlayersByPartyId(partyId: Int): List<PlayerDTO>
}