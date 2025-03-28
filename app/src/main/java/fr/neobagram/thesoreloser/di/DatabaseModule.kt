package fr.neobagram.thesoreloser.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.neobagram.thesoreloser.data.local.TSLDatabase
import fr.neobagram.thesoreloser.data.local.dao.GameDao
import fr.neobagram.thesoreloser.data.local.dao.PlayerDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideTSLDatabase(@ApplicationContext context: Context): TSLDatabase {
        return TSLDatabase.getDatabase(context)
    }

    @Provides
    fun providePlayerDao(appDatabase: TSLDatabase): PlayerDao {
        return appDatabase.playerDao()
    }

    @Provides
    fun provideGameDao(appDatabase: TSLDatabase): GameDao {
        return appDatabase.gameDao()
    }

}