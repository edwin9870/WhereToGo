package com.edwin.android.wheretogo.dto

/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
data class EventDTO(val id: Long,
                    val name: String,
                    val place: String,
                    val eventDateTime: Long,
                    val price: Double,
                    val backdropUrl: String)