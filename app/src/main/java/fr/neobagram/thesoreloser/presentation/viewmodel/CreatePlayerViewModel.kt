package fr.neobagram.thesoreloser.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.neobagram.thesoreloser.domain.model.PlayerDTO
import fr.neobagram.thesoreloser.domain.usecase.CreatePlayerUseCase
import fr.neobagram.thesoreloser.domain.usecase.GetAllPlayersUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatePlayerViewModel @Inject constructor(
    private val createPlayerUseCase: CreatePlayerUseCase,
    private val getAllPlayersUseCase: GetAllPlayersUseCase
): ViewModel() {
    private val _players = MutableLiveData<List<PlayerDTO>>()
    val players: LiveData<List<PlayerDTO>>
        get() = _players

    fun getAllPlayers()  {
        viewModelScope.launch {
            _players.value = getAllPlayersUseCase()
        }
    }

    fun createPlayer(playerDTO: PlayerDTO) {
        viewModelScope.launch {
            createPlayerUseCase(playerDTO)

            getAllPlayers()
        }
    }
}