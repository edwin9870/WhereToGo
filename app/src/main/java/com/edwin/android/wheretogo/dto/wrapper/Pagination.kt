package com.edwin.android.wheretogo.dto.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
class Pagination {

    @SerializedName("has_more_items")
    var hasMoreItems: Boolean? = null
    @SerializedName("object_count")
    var objectCount: Long? = null
    @SerializedName("page_count")
    var pageCount: Long? = null
    @SerializedName("page_number")
    var pageNumber: Long? = null
    @SerializedName("page_size")
    var pageSize: Long? = null

}
