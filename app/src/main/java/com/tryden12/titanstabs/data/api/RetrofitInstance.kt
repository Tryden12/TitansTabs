package com.tryden12.titanstabs.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val builder : Retrofit = Retrofit.Builder()
        .baseUrl("https://www.thesportsdb.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RetrofitApi = builder.create(RetrofitApi::class.java)

}