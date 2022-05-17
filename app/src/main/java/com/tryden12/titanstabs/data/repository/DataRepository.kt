package com.tryden12.titanstabs.data.repository

import com.tryden12.titanstabs.data.api.ApiService
import com.tryden12.titanstabs.data.model.Players

class DataRepository(private val playersApi : ApiService) {

    suspend fun getPlayers() : Players {
        return playersApi.getPlayers()
    }

}