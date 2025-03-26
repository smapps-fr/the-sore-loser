package fr.neobagram.thesoreloser.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.neobagram.thesoreloser.data.local.entity.Game

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM games")
    suspend fun getAllGames(): List<Game>

    @Query("DELETE FROM games")
    suspend fun deleteAllGames()
}