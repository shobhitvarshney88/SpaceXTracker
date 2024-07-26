package com.android.spacextracker.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UrlEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun urlDao(): UrlDao
}