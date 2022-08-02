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

    @Query("SELECT * FROM diets ORDER BY id DESC LIMIT 1")
    fun getLastEntry(): Flow<Diet>

    // Latest entry should be displayed first
    @Query("SELECT * FROM diets ORDER BY time_of_measurement DESC")
    fun getAllEntries(): Flow<List<Diet>>

    // ------------------------ Get specific values from an entry ------------------------
    // Get all body circumferences of an entry
    @Query(
        "SELECT bodyweight, chest, waist, hips, thigh_left, thigh_right, calf_left, " +
                "calf_right,upper_arm_left, upper_arm_right, forearm_left, forearm_right " +
                "FROM diets WHERE id = :id"
    )
    fun getCircumferences(id: Int): Flow<List<Double>>
}