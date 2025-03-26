package fr.neobagram.thesoreloser.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parties")
data class Party(
    @PrimaryKey(autoGenerate = true) val partyId: Int = 0,
    val name: String
)
