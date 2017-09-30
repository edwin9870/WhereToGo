package com.edwin.android.wheretogo.models.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
data class Logo (

    @SerializedName("aspect_ratio")
    val aspectRatio: String? = null,
    @SerializedName("crop_mask")
    val cropMask: CropMask? = null,
    @SerializedName("edge_color")
    val edgeColor: String? = null,
    @SerializedName("edge_color_set")
    val edgeColorSet: Boolean? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("original")
    val original: Original? = null,
    @SerializedName("url")
    val url: String? = null
)
