package com.tryden12.titanstabs.data.api

import android.telecom.Call
import com.tryden12.titanstabs.data.model.Player
import retrofit2.http.GET

interface ApiService {

    @GET
    fun getPlayer() : Player

}