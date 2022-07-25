package com.tryden12.titanstabs.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tryden12.titanstabs.data.model.DashIcons

class IconDashboardViewModel() : ViewModel(){

    var liveDataDashIcons: MutableLiveData<MutableList<DashIcons>> = MutableLiveData()

    var liveItemData: MutableLiveData<DashIcons> = MutableLiveData()

    // Observer for live list
    fun getLiveDataObserver(): MutableLiveData<MutableList<DashIcons>> {
        return liveDataDashIcons
    }

    // Observer for each icon
    fun getLiveItemObserver(): MutableLiveData<DashIcons> {
        return liveItemData
    }


}