package com.tryden12.titanstabs.data.api

import android.telecom.Call

import com.tryden12.titanstabs.data.model.Players
import retrofit2.http.GET

interface PlayersApi {

    @GET
    fun getPlayers() : Players

}