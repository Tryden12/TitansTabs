package com.tryden12.titanstabs.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tryden12.titanstabs.data.repository.DataRepository
import com.tryden12.titanstabs.data.model.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel : ViewModel() {

    // Test ViewModel with text below
    val textHello = "Some text from ViewModel"

    private val dataRepository = DataRepository()

/*
    fun fetchPlayer() : Player {
        return dataRepository.getPlayers().player[0]

        viewModelScope.launch {
            val player : Player = withContext(Dispatchers.IO) {
                dataRepository.getPlayers().player[0]
            }
            playerLiveData.value = player
        }


    }
*/




    //private val dataRepository = DataRepository(RetrofitInstance.service)
    val playerLiveData = MutableLiveData<Player>()


}