package fr.neobagram.thesoreloser.data.local.entity

import androidx.room.Entity

@Entity(tableName = "games_parties", primaryKeys = ["gameId", "partyId"])
data class GameParty(
    val gameId:Int,
    val partyId:Int
)
