package com.tryden12.titanstabs.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.data.model.Player
import com.tryden12.titanstabs.ui.main.view.SearchResultsFragment
import kotlinx.android.synthetic.main.item_player.view.*
import kotlinx.coroutines.NonDisposableHandle.parent
import org.w3c.dom.Text

class Adapter : RecyclerView.Adapter<Adapter.ItemViewHolder>() {


    // List of players
    private var playerList: List<Player>? = null

    // Set list of players
    fun setPlayerList(playerList: List<Player>) {
        this.playerList = playerList
    }

    // Get list of players
    fun getPlayerList(): List<Player>? {
        return playerList
    }


    // Setup ViewHolder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_player, parent, false)
        return ItemViewHolder(view)
    }

    // Bind player info to view holder
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val player = playerList!![position]
        holder.bind(playerList?.get(position))

        holder.view.findViewById<View>(R.id.item_linear_layout).setOnClickListener {
            // Get data for position
            val playerName = playerList?.get(position)?.strPlayer
            val playerPosition = playerList?.get(position)?.strPosition
            //val playerNumber = playerList?.get(position)?.strNumber
            //val playerImage = playerList?.get(position)?.strCutout

           // Picasso.get().load(player.strCutout).into(holder.view.findViewById(R.id.player_image))

            // Send data to next fragment
            val intent = Intent(holder.view.context, SearchResultsFragment::class.java)
            intent.putExtra("playerName", playerName)
            intent.putExtra("playerPosition", playerPosition)
            holder.view.context.startActivity(intent)
        }

        /*
        val player = playerList!![pos]
        ItemViewHolder.name.text = player.strPlayer.toString()
        ItemViewHolder.position.text = player.strPosition.toString()
        //customViewHolder.image.text = textWithImage.imageSrc.toString()

         Picasso.get().load(player.strThumb).into(ItemViewHolder.image)
         */

    }

    override fun getItemCount(): Int {
        return if (playerList == null) 0 else playerList!!.size
    }

    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        // Create variables for items in item_player layout
        private val playerName: TextView = view.findViewById(R.id.player_name)
        private val playerPosition: TextView = view.findViewById(R.id.player_position)
        private val playerNumber: TextView = view.findViewById(R.id.player_number)
        private val playerImage: ImageView = view.findViewById(R.id.player_image)

        // Bind data to player variables
        fun bind(data: Player?) {
                playerName.text = data!!.strPlayer
                playerPosition.text = data!!.strPosition
                //playerNumber.text = data.strNumber
                //playerImage.setImageResource(R.id.player_image) = data.strCutout

        }

    }
}