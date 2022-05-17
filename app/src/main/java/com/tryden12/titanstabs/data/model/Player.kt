package com.tryden12.titanstabs.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Player {

    @Expose
    @SerializedName("strPlayer")
    var name: String? = null

    @Expose
    @SerializedName("strPosition")
    var position: String? = null

    @Expose
    @SerializedName("strThumb")
    var image: String? = null

    @Expose
    @SerializedName("dateBorn")
    var born: String? = null

    @Expose
    @SerializedName("strHeight")
    var height: String? = null

    @Expose
    @SerializedName("strWeight")
    var weight: String? = null

    @Expose
    @SerializedName("strDescriptionEN")
    var description: String? = null


}