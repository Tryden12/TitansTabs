package com.tryden12.titanstabs.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Players (
    val player: List<Player>
)


@JsonClass(generateAdapter = true)
data class Player(

    val idPlayer: String? = null,
    val idTeam: String? = null,
    val idTeam2: String? = null,
    val idTeamNational: String? = null,
    val idSoccerXML: String? = null,
    val idAPIfootball: String? = null,
    val idPlayerManager: String? = null,
    val strNationality: String? = null,
    var strPlayer: String? = null,
    val strPlayerAlternate: String? = null,
    val strTeam: String? = null,
    val strTeam2: String? = null,
    val strSport: String? = null,
    val intSoccerXMLTeamID: String? = null,
    val dateBorn: String? = null,
    val strNumber: String? = null,
    val dateSigned: String? = null,
    val strSigning: String? = null,
    val strWage: String? = null,
    val strOutfitter: String? = null,
    val strKit: String? = null,
    val strAgent: String? = null,
    val strBirthLocation: String? = null,
    val strDescriptionEN: String? = null,
    val strDescriptionDE: String? = null,
    val strDescriptionFR: String? = null,
    val strDescriptionCN: String? = null,
    val strDescriptionIT: String? = null,
    val strDescriptionJP: String? = null,
    val strDescriptionRU: String? = null,
    val strDescriptionES: String? = null,
    val strDescriptionPT: String? = null,
    val strDescriptionSE: String? = null,
    val strDescriptionNL: String? = null,
    val strDescriptionHU: String? = null,
    val strDescriptionNO: String? = null,
    val strDescriptionIL: String? = null,
    val strDescriptionPL: String? = null,
    val strGender: String? = null,
    val strSide: String? = null,
    var strPosition: String? = null,
    val strCollege: String? = null,
    val strFacebook: String? = null,
    val strWebsite: String? = null,
    val strTwitter: String? = null,
    val strInstagram: String? = null,
    val strYoutube: String? = null,
    val strHeight: String? = null,
    val strWeight: String? = null,
    val intLoved: String? = null,
    var strThumb: String? = null,
    val strCutout: String? = null,
    val strRender: String? = null,
    val strBanner: String? = null,
    val strFanart1: String? = null,
    val strFanart2: String? = null,
    val strFanart3: String? = null,
    val strFanart4: String? = null,
    val strCreativeCommons: String? = null,
    val strLocked: String? = null

)


/*class Players {
    val player: List<Player>? = null
}
 */