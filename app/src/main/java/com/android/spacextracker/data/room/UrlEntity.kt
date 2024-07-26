package com.android.spacextracker.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UrlEntity(
    @PrimaryKey val id: Int = 1,
    val url: String
)
