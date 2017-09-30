package com.edwin.android.wheretogo.models.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
data class Pagination (

    @SerializedName("has_more_items")
    val hasMoreItems: Boolean? = null,
    @SerializedName("object_count")
    val objectCount: Long? = null,
    @SerializedName("page_count")
    val pageCount: Long? = null,
    @SerializedName("page_number")
    val pageNumber: Long? = null,
    @SerializedName("page_size")
    val pageSize: Long? = null
)
