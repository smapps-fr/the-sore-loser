package fr.neobagram.thesoreloser.presentation.view.fragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.neobagram.thesoreloser.R
import fr.neobagram.thesoreloser.presentation.viewmodel.PartyStatsViewModel

class PartyStatsFragment : Fragment() {

    companion object {
        fun newInstance() = PartyStatsFragment()
    }

    private val viewModel: PartyStatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_party_stats, container, false)
    }
}