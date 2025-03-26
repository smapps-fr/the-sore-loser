package fr.neobagram.thesoreloser.domain.repository

import fr.neobagram.thesoreloser.domain.model.GameDTO

interface GameRepository {

    suspend fun getAllGames(): List<GameDTO>

}