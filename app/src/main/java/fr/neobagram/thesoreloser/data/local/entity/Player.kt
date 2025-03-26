package fr.neobagram.thesoreloser.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="players")
data class Player(
    @PrimaryKey(autoGenerate = true) val playerId:Int = 0,
    val username: String,
    val picture: String
)
