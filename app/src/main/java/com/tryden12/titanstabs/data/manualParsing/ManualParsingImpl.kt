package com.tryden12.titanstabs.data.manualParsing

import com.tryden12.titanstabs.data.api.ApiService
import com.tryden12.titanstabs.data.model.Player
import com.tryden12.titanstabs.data.model.Players

class ManualParsingImpl : ApiService{
    override fun getPlayers(): Players {
        return Players(listOf(
            Player(
                "Chester Rodgers",
                "Wide Receiver",
                "https://www.thesportsdb.com/images/media/player/cutout/q1y8wm1635863686.png",
                "1994-01-12",
                "6 ft 0 in (1.83 m)",
                "184 lb (83 kg)",
                "Chester Rogers (born January 12, 1994) is an American football wide receiver for the Tennessee Titans of the National Football League (NFL). " +
                        "He played college football at Grambling State and signed with the Indianapolis Colts as an undrafted free agent in 2016. " +
                        "Acting career Chester Rogers started acting when he was 10 years old with the stage name of Tre Rogers. " +
                        "His first movie, Constellation was filmed in his hometown of Huntsville, Alabama where he played a younger version of the character played by actor Billy Dee Williams. " +
                        "Afterwards, Chester and his mom decided to pursue acting, and move out to California for four years. " +
                        "During that time, he also was in Madea's Family Reunion, Re-Animated on Cartoon Network, and Dirty with Cuba Gooding Jr. " +
                        "He was also originally cast in both Everybody Hates Chris and House of Payne, before the parts were recast after changes were made to the shows. " +
                        "He then put acting on hold to go to Grambling State to pursue football. College career Rogers attended and played college football at Grambling State from 2012–2015."
            )
        ))
    }
}