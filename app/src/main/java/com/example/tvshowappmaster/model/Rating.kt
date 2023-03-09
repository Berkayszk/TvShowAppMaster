package com.example.tvshowappmaster.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(
    val average: Double
) : Parcelable