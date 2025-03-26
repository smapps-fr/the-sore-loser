package fr.neobagram.thesoreloser.presentation.view.fragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.neobagram.thesoreloser.R
import fr.neobagram.thesoreloser.presentation.viewmodel.GameplayViewModel

class GameplayFragment : Fragment() {

    companion object {
        fun newInstance() = GameplayFragment()
    }

    private val viewModel: GameplayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_gameplay, container, false)
    }
}