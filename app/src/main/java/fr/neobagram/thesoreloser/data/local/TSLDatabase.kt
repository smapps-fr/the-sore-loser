package fr.neobagram.thesoreloser.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import fr.neobagram.thesoreloser.data.local.converter.DateConverter
import fr.neobagram.thesoreloser.data.local.dao.GameDao
import fr.neobagram.thesoreloser.data.local.dao.PlayerDao
import fr.neobagram.thesoreloser.data.local.entity.Game
import fr.neobagram.thesoreloser.data.local.entity.GameHistory
import fr.neobagram.thesoreloser.data.local.entity.GameParty
import fr.neobagram.thesoreloser.data.local.entity.Player
import fr.neobagram.thesoreloser.data.local.entity.Party
import fr.neobagram.thesoreloser.data.local.entity.PartyPlayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    abstract fun gameDao(): GameDao

    companion object {
        @Volatile
        private var _instance: TSLDatabase? = null

        fun getDatabase(context: Context): TSLDatabase {
            return _instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TSLDatabase::class.java,
                    "tsl_db"
                )
                    .addCallback(initDatabaseCallback)
                    .build()

                _instance = instance
                instance
            }
        }

        private val initDatabaseCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                CoroutineScope(Dispatchers.IO).launch {
                    val gameDao = _instance?.gameDao()

                    gameDao?.insertGame(
                        Game(
                            gameId = 1,
                            name = "Mille Sabords !",
                            picture = "mille_sabords"
                        )
                    )
                }
            }
        }
    }
}