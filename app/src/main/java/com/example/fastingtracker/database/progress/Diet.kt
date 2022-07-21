package com.example.fastingtracker.database.progress

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

/**
 * Database table which contains information about current diet and body measurement of user.
 */
@Entity(tableName = "diets")
data class Diet(
    // autoGenerate = true guarantees that ID for each item is unique
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    /*
     User can create multiple diets like summer diet 2020 and winter diet 2021.
     Use dietName to get corresponding values/measures of a specific diet.
     */
    @NonNull @ColumnInfo(name = "diet_name") val dietName: String,

    // TODO: Implement Columns Before Picture and After Picture
    // TODO: Implement type of timeOfMeasurement. Unsure, if its right type for DatePicker
    @NonNull @ColumnInfo(name = "time_of_measurement") val timeOfMeasurement: Date,
    @ColumnInfo(name = "bodyweight") val bodyweight: Double,

    // Body circumferences - Most important ones first
    @ColumnInfo(name = "chest") val chest: Double,
    @ColumnInfo(name = "waist") val waist: Double,
    @ColumnInfo(name = "hips") val hips: Double,
    @ColumnInfo(name = "thigh_left") val thighLeft: Double,
    @ColumnInfo(name = "thigh_right") val thighRight: Double,
    @ColumnInfo(name = "calf_left") val calfLeft: Double,
    @ColumnInfo(name = "calf_right") val calfRight: Double,
    @ColumnInfo(name = "upper_arm_left") val upperArmLeft: Double,
    @ColumnInfo(name = "upper_arm_right") val upperArmRight: Double,
    @ColumnInfo(name = "forearm_left") val forearmLeft: Double,
    @ColumnInfo(name = "forearm_right") val forearmRight: Double,

    @ColumnInfo(name = "notes") val notes: String
)