package com.edwin.android.wheretogo.dto.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
class Event {

    @SerializedName("capacity")
    var capacity: Long? = null
    @SerializedName("capacity_is_custom")
    var capacityIsCustom: Boolean? = null
    @SerializedName("category_id")
    var categoryId: String? = null
    @SerializedName("changed")
    var changed: String? = null
    @SerializedName("created")
    var created: String? = null
    @SerializedName("currency")
    var currency: String? = null
    @SerializedName("description")
    var description: Description? = null
    @SerializedName("end")
    var end: End? = null
    @SerializedName("format_id")
    var formatId: String? = null
    @SerializedName("hide_end_date")
    var hideEndDate: Boolean? = null
    @SerializedName("hide_start_date")
    var hideStartDate: Boolean? = null
    @SerializedName("id")
    var id: String? = null
    @SerializedName("is_free")
    var isFree: Boolean? = null
    @SerializedName("is_locked")
    var isLocked: Boolean? = null
    @SerializedName("is_reserved_seating")
    var isReservedSeating: Boolean? = null
    @SerializedName("is_series")
    var isSeries: Boolean? = null
    @SerializedName("is_series_parent")
    var isSeriesParent: Boolean? = null
    @SerializedName("listed")
    var listed: Boolean? = null
    @SerializedName("locale")
    var locale: String? = null
    @SerializedName("logo")
    var logo: Logo? = null
    @SerializedName("logo_id")
    var logoId: String? = null
    @SerializedName("name")
    var name: Name? = null
    @SerializedName("online_event")
    var onlineEvent: Boolean? = null
    @SerializedName("organizer_id")
    var organizerId: String? = null
    @SerializedName("privacy_setting")
    var privacySetting: String? = null
    @SerializedName("resource_uri")
    var resourceUri: String? = null
    @SerializedName("series_id")
    var seriesId: String? = null
    @SerializedName("shareable")
    var shareable: Boolean? = null
    @SerializedName("source")
    var source: String? = null
    @SerializedName("start")
    var start: Start? = null
    @SerializedName("status")
    var status: String? = null
    @SerializedName("subcategory_id")
    var subcategoryId: Any? = null
    @SerializedName("tx_time_limit")
    var txTimeLimit: Long? = null
    @SerializedName("url")
    var url: String? = null
    @SerializedName("vanity_url")
    var vanityUrl: String? = null
    @SerializedName("venue_id")
    var venueId: String? = null
    @SerializedName("version")
    var version: String? = null

}
