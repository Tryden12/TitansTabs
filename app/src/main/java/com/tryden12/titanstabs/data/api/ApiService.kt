package com.tryden12.titanstabs.data.api

import android.telecom.Call
import com.tryden12.titanstabs.data.model.Player
import com.tryden12.titanstabs.data.model.Players
import retrofit2.http.GET

interface ApiService {

    @GET
    suspend fun getPlayers() : Players

}