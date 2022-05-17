package com.tryden12.titanstabs.data.manualParsing

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.tryden12.titanstabs.data.api.ApiService
import com.tryden12.titanstabs.data.model.Player
import com.tryden12.titanstabs.data.model.Players
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.net.URL
import java.net.URLConnection

class ManualParsingImpl : ApiService{
    override suspend fun getPlayers(): Players {

        val url = URL("https://www.thesportsdb.com/api/v1/json/50130162/searchplayers.php?t=Tennessee%Titans")
        val connection : URLConnection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferedReader: BufferedReader = bufferedInputStream.bufferedReader()

        val stringBuffer = StringBuffer()
        for(line in bufferedReader.lines()) {
            stringBuffer.append(line)
        }

        bufferedReader.close()

        val fullJson: String = stringBuffer.toString()

        return Gson().fromJson(fullJson, Players::class.java)

        /* // Json parsing test
        val jsonObjectPlayers = JSONObject(fullJson)
        val jsonArray : JSONArray = jsonObjectPlayers.getJSONArray("player")
        val jsonObjectPlayer : JSONObject = jsonArray.getJSONObject(0)

        val playerName : String = jsonObjectPlayer.getString("strPlayer")
        val playerPosition: String = jsonObjectPlayer.getString("strPosition")
        val playerHeight : String = jsonObjectPlayer.getString("strHeight")
        val playerWeight : String = jsonObjectPlayer.getString("strWeight")
        val playerBorn : String = jsonObjectPlayer.getString("dateBorn")
        val playerImage : String = jsonObjectPlayer.getString("strThumb")
        val playerDesc : String = jsonObjectPlayer.getString("strDescriptionEN")
        return Players(listOf(
            Player(
                playerName, playerPosition, playerHeight, playerWeight, playerBorn, playerDesc,playerImage
            )
        ))
        */
    }
}