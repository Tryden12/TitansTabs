package com.tryden12.titanstabs.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tryden12.titanstabs.utils.Constants
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import com.tryden12.titanstabs.utils.Constants.BASE_URL
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {

    // Base Url located in constants

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