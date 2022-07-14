package com.example.fastingtracker

import android.app.Application
import com.example.fastingtracker.database.AppDatabase

/**
 * Shares singleton objects or components (e. g. database) between activities and fragments.
 * Is instantiated when app is loaded.
 */
class FastingTrackerApplication : Application() {

    // lazy initialization due to performance optimization
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}