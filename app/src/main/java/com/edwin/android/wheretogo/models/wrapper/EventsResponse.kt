package com.edwin.android.wheretogo.models.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
data class EventsResponse (

    @SerializedName("events")
    val events: List<Event>? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("pagination")
    val pagination: Pagination? = null
)
