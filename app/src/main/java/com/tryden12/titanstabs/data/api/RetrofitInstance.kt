package com.tryden12.titanstabs.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {

    // Base Url
    private const val BASE_URL: String =
        "https://www.thesportsdb.com/api/v1/json/50130162/" // searchplayers.php?t=Tennessee%Titans

    // Create Moshi instance
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()!!

    private val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    // Http Client
    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    // Create Retro instance
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    // Create Api Service
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}