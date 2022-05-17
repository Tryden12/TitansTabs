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

class Adapter(private val context: Context?, private var playerList: List<Player>?) :
    RecyclerView.Adapter<Adapter.CustomViewHolder>() {

    fun dataChanged(playerList: List<Player>) {
        this.playerList = playerList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CustomViewHolder {
        val mView = LayoutInflater.from(context)
            .inflate(R.layout.item_player, viewGroup, false)
        return CustomViewHolder(mView)
    }

    override fun onBindViewHolder(customViewHolder: CustomViewHolder, pos: Int) {
        val player = playerList!![pos]
        customViewHolder.name.text = player.strPlayer.toString()
        customViewHolder.position.text = player.strPosition.toString()
        //customViewHolder.image.text = textWithImage.imageSrc.toString()

         Picasso.get().load(player.strThumb).into(customViewHolder.image)


    }

    override fun getItemCount(): Int {
        return if (playerList == null) 0 else playerList!!.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var name : TextView
        var position : TextView

        init {
            image    = itemView.findViewById(R.id.item_imageview)
            name    = itemView.findViewById(R.id.item_name)
            position = itemView.findViewById(R.id.item_position)
        }

    }
}