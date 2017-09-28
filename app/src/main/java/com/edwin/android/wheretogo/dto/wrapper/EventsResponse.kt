package com.edwin.android.wheretogo.dto.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
class EventsResponse {

    @SerializedName("events")
    var events: List<Event>? = null
    @SerializedName("location")
    var location: Location? = null
    @SerializedName("pagination")
    var pagination: Pagination? = null

}
