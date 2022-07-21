package com.example.fastingtracker.database.progress

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Contains SQL commands/queries that belong to the "progress" section of the app.
 */
@Dao
interface DietDao {
    // ------------------------ SQL-commands to modify an entry ------------------------
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entry: Diet)

    @Update
    suspend fun update(entry: Diet)

    @Delete
    suspend fun delete(entry: Diet)

    // ------------------------ Get entries ------------------------
    @Query("SELECT * FROM diets WHERE id = :id")
    fun getEntry(id: Int): Flow<Diet>

    // Latest entry should be displayed first
    @Query("SELECT * FROM diets ORDER BY time_of_measurement DESC")
    fun getAllEntries(): Flow<List<Diet>>
}