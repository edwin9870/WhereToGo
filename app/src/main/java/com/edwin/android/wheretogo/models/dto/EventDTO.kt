package com.edwin.android.wheretogo.models.dto

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */

data class EventDTO(var id: Long,
                    var title: String,
                    var place: String,
                    var eventDateTime: Long,
                    var price: Double,
                    var backdropUrl: String?,
                    var isFavorite: Boolean = false) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(title)
        parcel.writeString(place)
        parcel.writeLong(eventDateTime)
        parcel.writeDouble(price)
        parcel.writeString(backdropUrl)
        parcel.writeByte(if (isFavorite) 1 else 0)
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