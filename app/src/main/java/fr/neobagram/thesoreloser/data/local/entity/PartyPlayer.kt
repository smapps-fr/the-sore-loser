package fr.neobagram.thesoreloser.data.local.entity

import androidx.room.Entity

@Entity(tableName = "parties_players", primaryKeys = ["partyId", "playerId"])
data class PartyPlayer(
    val partyId: Int,
    val playerId: Int
)
