package fr.neobagram.thesoreloser.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.neobagram.thesoreloser.data.local.converter.DateConverter
import fr.neobagram.thesoreloser.data.local.dao.PlayerDao
import fr.neobagram.thesoreloser.data.local.entity.Game
import fr.neobagram.thesoreloser.data.local.entity.GameHistory
import fr.neobagram.thesoreloser.data.local.entity.GameParty
import fr.neobagram.thesoreloser.data.local.entity.Player
import fr.neobagram.thesoreloser.data.local.entity.Party
import fr.neobagram.thesoreloser.data.local.entity.PartyPlayer

@Database(entities = [Player::class,
                     Party::class,
                     PartyPlayer::class,
                     Game::class,
                     GameParty::class,
                     GameHistory::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class TSLDatabase: RoomDatabase() {
    abstract fun playerDao(): PlayerDao
}