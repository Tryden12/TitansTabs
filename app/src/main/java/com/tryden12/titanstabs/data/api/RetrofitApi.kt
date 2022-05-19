package com.tryden12.titanstabs.data.api

import com.tryden12.titanstabs.data.model.Players
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitApi  {

    @GET("/api/v1/json/50130162/searchplayers.php?t=Tennessee%Titans")
    suspend fun getPlayers(): Players


}