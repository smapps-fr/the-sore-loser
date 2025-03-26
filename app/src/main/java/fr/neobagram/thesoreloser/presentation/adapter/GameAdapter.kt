package fr.neobagram.thesoreloser.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import fr.neobagram.thesoreloser.R
import fr.neobagram.thesoreloser.domain.model.GameDTO
import fr.neobagram.thesoreloser.presentation.view.fragment.GameListFragmentDirections

class GameAdapter(var games: List<GameDTO>): RecyclerView.Adapter<GameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item_game, parent, false)

        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        val context = holder.itemView.context

        val drawableResId = context.resources.getIdentifier(game.picture, "drawable", context.packageName)
        if(drawableResId != 0) {
            holder.ivGamePicture.setImageDrawable(context.getDrawable(drawableResId))
        }


        holder.view.setOnClickListener {
            val action = GameListFragmentDirections.actionGameListFragmentToPartyListFragment(game.gameId)
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return games.size
    }
}

class GameViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val ivGamePicture: ImageView = view.findViewById(R.id.iv_game_picture)
}