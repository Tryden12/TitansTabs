package com.tryden12.titanstabs.data.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.data.model.Player
import com.tryden12.titanstabs.ui.main.view.PlayerDetailsFragment

class Adapter : RecyclerView.Adapter<Adapter.ItemViewHolder>() {


    // List of players
    private var playerList: List<Player>? = null

    // Set list of players
    fun setPlayerList(playerList: List<Player>?) {
        this.playerList = playerList
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
        holder.bind(playerList?.get(position))

        // Get data for position
        val playerName = playerList?.get(position)?.strPlayer
        val playerPosition = playerList?.get(position)?.strPosition
        val playerNumber = playerList?.get(position)?.strNumber
        val playerHeight = playerList?.get(position)?.strHeight
        val playerWeight = playerList?.get(position)?.strWeight
        val playerAge = playerList?.get(position)?.strAge
        val playerImage = playerList?.get(position)?.strThumb
        val playerExperience = playerList?.get(position)?.strExperience
        val playerCollege = playerList?.get(position)?.strCollege
        val playerBio = playerList?.get(position)?.strBio

        // Load image into imageview
        Glide.with(holder.view.context)
            .load(playerImage)
            .into(holder.view.findViewById(R.id.player_image))



        holder.view.findViewById<View>(R.id.item_linear_layout).setOnClickListener {
            // Send data to next fragment

            /*

            Check your bookmarks to learn how to send data from one frag to another from recyclerview

             */



            val intent = Intent(holder.view.context, PlayerDetailsFragment::class.java)
            intent.putExtra("name", playerName)
            intent.putExtra("position", playerPosition)
            intent.putExtra("number", playerNumber)
            intent.putExtra("height", playerHeight)
            intent.putExtra("weight", playerWeight)
            intent.putExtra("age", playerAge)
            intent.putExtra("image", playerImage)
            intent.putExtra("college", playerCollege)
            intent.putExtra("bio", playerBio)

            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return if (playerList == null) 0
        else playerList?.size!!
    }

    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        // Create variables for items in item_player layout
        private val playerName: TextView = view.findViewById(R.id.player_name)
        private val playerPosition: TextView = view.findViewById(R.id.player_position)
        private val playerNumber: TextView = view.findViewById(R.id.player_number)
        private val playerImage: ImageView = view.findViewById(R.id.player_image)

        // Bind data to player variables
        fun bind(data : Player?) {
            if (data != null) {
                playerName.text = data.strPlayer
                playerPosition.text = data.strPosition
                playerNumber.text = data.strNumber
            }
        }
    }
}