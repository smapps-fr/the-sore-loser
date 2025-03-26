package fr.neobagram.thesoreloser.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.neobagram.thesoreloser.data.local.dao.GameDao
import fr.neobagram.thesoreloser.data.repository.GameRepositoryImpl
import fr.neobagram.thesoreloser.domain.repository.GameRepository
import fr.neobagram.thesoreloser.domain.usecase.GetAllGamesUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GameModule {

    @Provides
    @Singleton
    fun provideGameRepository(gameDao: GameDao): GameRepository {
        return GameRepositoryImpl(gameDao)
    }

    @Provides
    fun provideGetAllGamesUseCase(gameRepository: GameRepository): GetAllGamesUseCase {
        return GetAllGamesUseCase(gameRepository)
    }
}