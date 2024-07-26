package com.android.spacextracker.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UrlDao {
    @Query("SELECT * FROM UrlEntity LIMIT 1")
    suspend fun getUrl(): UrlEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUrl(urlEntity: UrlEntity)
}