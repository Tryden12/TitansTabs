package com.tryden12.titanstabs.data.repository

import com.tryden12.titanstabs.data.api.RetrofitInstance.apiService
import com.tryden12.titanstabs.data.model.Player
import com.tryden12.titanstabs.data.model.Players
import retrofit2.Call

class DataRepository() {


    fun getPlayers() : Call<MutableList<Player>> {
        return apiService.getPlayers()
    }



}