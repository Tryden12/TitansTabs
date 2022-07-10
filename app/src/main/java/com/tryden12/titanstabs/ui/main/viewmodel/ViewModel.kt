package com.tryden12.titanstabs.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tryden12.titanstabs.data.api.RetrofitInstance.apiService
import com.tryden12.titanstabs.data.repository.DataRepository
import com.tryden12.titanstabs.data.model.Player
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel : ViewModel() {

    private val dataRepository = DataRepository()

    // Live data for the list from Api
    var liveDataList: MutableLiveData<MutableList<Player>> = MutableLiveData()

    // Live data for each item
    var liveItemData: MutableLiveData<Player> = MutableLiveData()

    // Observer for live list
    fun getLiveDataObserver(): MutableLiveData<MutableList<Player>> {
        return liveDataList
    }

    // Observer for each item
    fun getLiveItemObserver(): MutableLiveData<Player> {
        return liveItemData
    }

    // Make Api call for list data
    fun makeApiCall() {
        val call = apiService.getPlayers()
        call.enqueue(object : Callback<MutableList<Player>> {
            override fun onResponse(
                call: Call<MutableList<Player>>,
                response: Response<MutableList<Player>>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<Player>>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })
    }

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