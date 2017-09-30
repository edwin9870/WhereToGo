package com.edwin.android.wheretogo.models.wrapper

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("net.hexar.json2pojo")
data class Event (

    @SerializedName("capacity")
    val capacity: Long? = null,
    @SerializedName("capacity_is_custom")
    val capacityIsCustom: Boolean? = null,
    @SerializedName("category_id")
    val categoryId: String? = null,
    @SerializedName("changed")
    val changed: String? = null,
    @SerializedName("created")
    val created: String? = null,
    @SerializedName("currency")
    val currency: String? = null,
    @SerializedName("description")
    val description: Description? = null,
    @SerializedName("end")
    val end: End? = null,
    @SerializedName("format_id")
    val formatId: String? = null,
    @SerializedName("hide_end_date")
    val hideEndDate: Boolean? = null,
    @SerializedName("hide_start_date")
    val hideStartDate: Boolean? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("is_free")
    val isFree: Boolean? = null,
    @SerializedName("is_locked")
    val isLocked: Boolean? = null,
    @SerializedName("is_reserved_seating")
    val isReservedSeating: Boolean? = null,
    @SerializedName("is_series")
    val isSeries: Boolean? = null,
    @SerializedName("is_series_parent")
    val isSeriesParent: Boolean? = null,
    @SerializedName("listed")
    val listed: Boolean? = null,
    @SerializedName("locale")
    val locale: String? = null,
    @SerializedName("logo")
    val logo: Logo? = null,
    @SerializedName("logo_id")
    val logoId: String? = null,
    @SerializedName("name")
    val name: Name? = null,
    @SerializedName("online_event")
    val onlineEvent: Boolean? = null,
    @SerializedName("organizer_id")
    val organizerId: String? = null,
    @SerializedName("privacy_setting")
    val privacySetting: String? = null,
    @SerializedName("resource_uri")
    val resourceUri: String? = null,
    @SerializedName("series_id")
    val seriesId: String? = null,
    @SerializedName("shareable")
    val shareable: Boolean? = null,
    @SerializedName("source")
    val source: String? = null,
    @SerializedName("start")
    val start: Start? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("subcategory_id")
    val subcategoryId: Any? = null,
    @SerializedName("tx_time_limit")
    val txTimeLimit: Long? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("vanity_url")
    val vanityUrl: String? = null,
    @SerializedName("venue_id")
    val venueId: String? = null,
    @SerializedName("version")
    val version: String? = null
)
