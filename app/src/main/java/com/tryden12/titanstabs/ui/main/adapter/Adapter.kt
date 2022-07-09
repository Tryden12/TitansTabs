package com.tryden12.titanstabs.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.data.model.Player
import kotlinx.coroutines.NonDisposableHandle.parent

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
    override fun onBindViewHolder(holder: ItemViewHolder, pos: Int) {
        //holder.

        val player = playerList!![pos]
        ItemViewHolder.name.text = player.strPlayer.toString()
        ItemViewHolder.position.text = player.strPosition.toString()
        //customViewHolder.image.text = textWithImage.imageSrc.toString()

         Picasso.get().load(player.strThumb).into(ItemViewHolder.image)


    }

    override fun getItemCount(): Int {
        return if (playerList == null) 0 else playerList!!.size
    }

    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        // Create variables for items in item_player layout
        private val

        /*
        var image: ImageView
        var name : TextView
        var position : TextView

        init {
            image    = itemView.findViewById(R.id.item_imageview)
            name    = itemView.findViewById(R.id.item_name)
            position = itemView.findViewById(R.id.item_position)
        }

         */

    }
}