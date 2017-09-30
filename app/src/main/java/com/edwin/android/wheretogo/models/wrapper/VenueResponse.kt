package com.edwin.android.wheretogo.models.wrapper

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("net.hexar.json2pojo")
data class VenueResponse (

    @SerializedName("address")
    val address: Address? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resource_uri")
    val resourceUri: String? = null
)