package com.fanqi.wankt.ui.mine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MineViewModel : ViewModel() {

    var mineData = MutableLiveData<String>()

    fun init() {
        mineData.postValue("卧槽")
    }
}
