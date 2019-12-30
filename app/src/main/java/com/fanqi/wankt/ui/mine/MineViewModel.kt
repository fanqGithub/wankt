package com.fanqi.wankt.ui.mine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fanqi.wankt.base.Preference
import com.fanqi.wankt.common.bean.MineData
import com.fanqi.wankt.constant.Constant

class MineViewModel : ViewModel() {

    var mineData = MutableLiveData<MineData>()

    fun initUserData() {
        var userName by Preference(Constant.USER_NAME, "")
        var userData = MineData()
        userData.userName = userName

        mineData.postValue(userData)
    }


}
