package com.tryden12.titanstabs.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import com.tryden12.titanstabs.data.repository.DataRepository

class ViewModel : ViewModel() {
    val testText = "This is some test text"

    private val dataRepository = DataRepository()

    fun fetchPlayer() {
        // come back
    }
}