package fr.neobagram.thesoreloser.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "games_history")
data class GameHistory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val gameId: Int,
    val tableId: Int,
    val winnerId: Int,
    val date: Date,
    // JSON string containing the game final scores, it will be decoded depending on the game
    val result: String
)
