package com.android.spacextracker

import android.app.Application
import androidx.room.Room
import com.android.spacextracker.data.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "rocketDb").build()
    }
}