package fr.neobagram.thesoreloser.presentation.view.fragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import dagger.hilt.android.AndroidEntryPoint
import fr.neobagram.thesoreloser.R
import fr.neobagram.thesoreloser.databinding.FragmentGameListBinding
import fr.neobagram.thesoreloser.domain.model.PlayerDTO
import fr.neobagram.thesoreloser.presentation.adapter.GameAdapter
import fr.neobagram.thesoreloser.presentation.viewmodel.CreatePlayerViewModel
import fr.neobagram.thesoreloser.presentation.viewmodel.GameListViewModel

@AndroidEntryPoint
class GameListFragment : Fragment() {

    // region Properties

    private lateinit var _binding: FragmentGameListBinding
    private val _gameListVM: GameListViewModel by viewModels()

    private val _gameAdapter: GameAdapter = GameAdapter(listOf())
    // endregion

    // region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _gameListVM.getAllGames()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameListBinding.inflate(layoutInflater)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.rvGames.adapter = _gameAdapter

        setActions()
        setObservers()
    }

    // endregion

    // region Private Methods

    private fun setActions() {

    }

    private fun setObservers() {
        _gameListVM.games.observe(viewLifecycleOwner, { games ->
            _gameAdapter.games = games
            _gameAdapter.notifyDataSetChanged()
            //_gameAdapter.notifyItemRangeChanged(0, _gameAdapter.itemCount)
        })
    }

    // endregion
}