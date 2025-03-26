package fr.neobagram.thesoreloser.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import fr.neobagram.thesoreloser.databinding.FragmentCreatePlayerBinding
import fr.neobagram.thesoreloser.presentation.viewmodel.CreatePlayerViewModel

@AndroidEntryPoint
class CreatePlayerFragment : Fragment() {
    // region Properties

    private lateinit var _binding: FragmentCreatePlayerBinding
    private val _createPlayerVM: CreatePlayerViewModel by viewModels()

    // endregion

    // region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreatePlayerBinding.inflate(layoutInflater)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setActions()
        setObservers()

        _createPlayerVM.getAllPlayers()
    }

    // endregion

    // region Private Methods

    private fun setActions() {
        _binding.btnCreate.setOnClickListener {
            if(_binding.etUsername.text.toString().isNotBlank()) {
                /*
                _createPlayerVM.createPlayer(
                    PlayerDTO(username = _binding.etUsername.text.toString())
                )

                 */
            }
        }
    }

    private fun setObservers() {
        _createPlayerVM.players.observe(viewLifecycleOwner, Observer { players ->
            _binding.tvUsers.text = players.toString()
        })
    }

    // endregion
}