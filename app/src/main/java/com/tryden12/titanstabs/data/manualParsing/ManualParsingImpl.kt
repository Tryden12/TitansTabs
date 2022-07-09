package com.tryden12.titanstabs.data.manualParsing

import com.tryden12.titanstabs.data.api.ApiService
import com.tryden12.titanstabs.data.model.Player

import com.tryden12.titanstabs.data.model.Players
import java.net.URL

class ManualParsingImpl : ApiService{
    override fun getPlayers(): Players {

        val url = URL("https://www.thesportsdb.com/api/v1/json/50130162/searchplayers.php?t=Tennessee%Titans")
        /*
        //val url = URL("https://my-json-server.typicode.com/Tryden12/mockjson/db")
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

         // Json parsing test
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

        return Players(listOf(
            Player(
                "Tyler Ryden", "RB", "5'7","150lbs",
                "03/22/1993", "This is a test desc", ""
            )
        ))

    }
}