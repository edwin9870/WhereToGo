package com.edwin.android.wheretogo.models.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
data class Address (

    @SerializedName("address_1")
    val address1: String? = null,
    @SerializedName("address_2")
    val address2: Any? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("localized_address_display")
    val localizedAddressDisplay: String? = null,
    @SerializedName("localized_area_display")
    val localizedAreaDisplay: String? = null,
    @SerializedName("localized_multi_line_address_display")
    val localizedMultiLineAddressDisplay: List<String>? = null,
    @SerializedName("longitude")
    val longitude: String? = null,
    @SerializedName("postal_code")
    val postalCode: Any? = null,
    @SerializedName("region")
    val region: String? = null
)