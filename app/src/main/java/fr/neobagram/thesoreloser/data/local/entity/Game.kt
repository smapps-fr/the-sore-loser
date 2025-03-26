package fr.neobagram.thesoreloser.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class Game(
    @PrimaryKey(autoGenerate = false) val gameId: Int = 0,
    val name: String,
    val picture: String
)
