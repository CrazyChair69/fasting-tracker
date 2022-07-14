package com.example.fastingtracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fastingtracker.database.progress.Diet
import com.example.fastingtracker.database.progress.DietDao

/**
 * Database for entire Fasting Tracker App.
 * Can only be instantiated once due to performance reasons.
 */
@Database(entities = [Diet::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    // Allows other classes easy access to DAO
    abstract fun dietDao(): DietDao

    // Ensures that only one instance of database exists to prevent race conditions or other issues.
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Either return the existing instance of the database (if it already exists)
         * or create the database for the first time if needed
         */
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}