package fr.neobagram.thesoreloser.data.mapper

import fr.neobagram.thesoreloser.data.local.entity.Game
import fr.neobagram.thesoreloser.domain.model.GameDTO

fun Game.toDTO(): GameDTO {
    return GameDTO(
        this.gameId,
        this.name,
        this.picture
    )
}