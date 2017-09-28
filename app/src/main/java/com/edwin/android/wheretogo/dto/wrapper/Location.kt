package com.edwin.android.wheretogo.dto.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
class Location {

    @SerializedName("address")
    var address: String? = null
    @SerializedName("augmented_location")
    var augmentedLocation: AugmentedLocation? = null
    @SerializedName("latitude")
    var latitude: String? = null
    @SerializedName("longitude")
    var longitude: String? = null
    @SerializedName("within")
    var within: String? = null

}
