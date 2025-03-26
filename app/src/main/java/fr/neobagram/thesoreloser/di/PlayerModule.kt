package fr.neobagram.thesoreloser.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.neobagram.thesoreloser.data.local.dao.PlayerDao
import fr.neobagram.thesoreloser.domain.repository.PlayerRepository
import fr.neobagram.thesoreloser.data.repository.PlayerRepositoryImpl
import fr.neobagram.thesoreloser.domain.usecase.CreatePlayerUseCase
import fr.neobagram.thesoreloser.domain.usecase.GetAllPlayersUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PlayerModule {

    @Provides
    @Singleton
    fun providePlayerRepository(playerDao: PlayerDao): PlayerRepository {
        return PlayerRepositoryImpl(playerDao)
    }

    @Provides
    fun provideCreatePlayerUseCase(playerRepository: PlayerRepository): CreatePlayerUseCase {
        return CreatePlayerUseCase(playerRepository)
    }
    /*
    @Provides
    fun provideGetAllPlayersUseCase(playerRepository: PlayerRepository): GetAllPlayersUseCase {
        return GetAllPlayersUseCase(playerRepository)
    }

     */

}