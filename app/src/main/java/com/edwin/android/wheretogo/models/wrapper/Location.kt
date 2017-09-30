package com.edwin.android.wheretogo.models.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
data class Location (

    @SerializedName("address")
    val address: String? = null,
    @SerializedName("augmented_location")
    val augmentedLocation: AugmentedLocation? = null,
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null,
    @SerializedName("within")
    val within: String? = null
)
