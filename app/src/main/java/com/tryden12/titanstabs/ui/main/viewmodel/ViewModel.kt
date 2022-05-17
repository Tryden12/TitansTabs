package com.tryden12.titanstabs.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tryden12.titanstabs.data.manualParsing.ManualParsingImpl
import com.tryden12.titanstabs.data.repository.DataRepository
import com.tryden12.titanstabs.data.model.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel : ViewModel() {
    private val dataRepository = DataRepository(ManualParsingImpl())


    val playerLiveData = MutableLiveData<Player>()


    fun fetchPlayer() {
        viewModelScope.launch {
            val player : Player = withContext(Dispatchers.IO) {
                dataRepository.getPlayers().player[0]
            }
            playerLiveData.value = player
        }
    }
}