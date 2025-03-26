package fr.neobagram.thesoreloser.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.neobagram.thesoreloser.domain.model.GameDTO
import fr.neobagram.thesoreloser.domain.usecase.GetAllGamesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameListViewModel @Inject constructor(
    private val getAllGamesUseCase: GetAllGamesUseCase
): ViewModel() {
    private val _games = MutableLiveData<List<GameDTO>>()
    val games: LiveData<List<GameDTO>>
        get() = _games

    fun getAllGames() {
        viewModelScope.launch {
            _games.value = getAllGamesUseCase()
        }

    }
}