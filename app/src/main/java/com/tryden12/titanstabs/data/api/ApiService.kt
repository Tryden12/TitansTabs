package com.tryden12.titanstabs.data.api

import com.tryden12.titanstabs.data.model.Player
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("searchplayers.php?t=Tennessee%Titans")
    fun getPlayers() : Call<MutableList<Player>>

}