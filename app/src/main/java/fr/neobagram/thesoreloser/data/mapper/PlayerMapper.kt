package fr.neobagram.thesoreloser.data.mapper

import fr.neobagram.thesoreloser.data.local.entity.Player
import fr.neobagram.thesoreloser.domain.model.PlayerDTO


fun Player.toDTO(): PlayerDTO {
    return PlayerDTO(
        this.playerId,
        this.username,
        this.picture
    )
}

fun PlayerDTO.toDb(): Player {
    return if(this.playerId != -1) {
        Player(
            playerId = this.playerId,
            username = this.username,
            picture = this.picture
        )
    } else {
        Player(
            username = this.username,
            picture = this.picture
        )
    }
}