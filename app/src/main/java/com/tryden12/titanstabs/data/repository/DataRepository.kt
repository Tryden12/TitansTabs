package com.tryden12.titanstabs.data.repository

import com.tryden12.titanstabs.data.manualParsing.ManualParsingImpl
import com.tryden12.titanstabs.data.model.Players

class DataRepository(private val playersApi: ManualParsingImpl) {

    suspend fun getPlayers() : Players {
        return playersApi.getPlayers()
    }

}