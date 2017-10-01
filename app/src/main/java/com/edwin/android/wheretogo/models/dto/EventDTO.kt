package com.edwin.android.wheretogo.models.dto

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */

data class EventDTO(val title: String,
                    val place: String,
                    val eventDateTime: Long,
                    val price: Double,
                    val backdropUrl: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readLong(),
            parcel.readDouble(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(place)
        parcel.writeLong(eventDateTime)
        parcel.writeDouble(price)
        parcel.writeString(backdropUrl)
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<EventDTO> {
            override fun createFromParcel(parcel: Parcel): EventDTO = EventDTO(parcel)

            override fun newArray(size: Int): Array<EventDTO?> = arrayOfNulls(size)
        }
    }
}