package com.edwin.android.wheretogo.dto.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
class Logo {

    @SerializedName("aspect_ratio")
    var aspectRatio: String? = null
    @SerializedName("crop_mask")
    var cropMask: CropMask? = null
    @SerializedName("edge_color")
    var edgeColor: String? = null
    @SerializedName("edge_color_set")
    var edgeColorSet: Boolean? = null
    @SerializedName("id")
    var id: String? = null
    @SerializedName("original")
    var original: Original? = null
    @SerializedName("url")
    var url: String? = null

}
