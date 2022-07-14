package com.example.fastingtracker.progress.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fastingtracker.database.progress.DietDao

/**
 * Instantiates ProgressViewModel, so fragment object doesn't have to
 * handle everything (e. g. memory management, lifecycle awareness).
 */
class ProgressViewModelFactory(private val dietDao: DietDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProgressViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProgressViewModel(dietDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}