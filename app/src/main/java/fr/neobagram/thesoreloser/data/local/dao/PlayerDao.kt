package fr.neobagram.thesoreloser.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.neobagram.thesoreloser.data.local.entity.Player

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: Player)

    @Query("SELECT * FROM players")
    suspend fun getAllPlayers(): List<Player>

    /*
    @Query(
        "SELECT p.* " +
        "FROM players p " +
        "JOIN parties_players pp ON p.playerId = pp.playerId " +
        "JOIN parties pa ON pp.partyId = pa.partyId " +
        "WHERE pa.partyId = :partyId"
    )
    suspend fun getPlayersByPartyId(partyId: Int): List<Player>

     */
}