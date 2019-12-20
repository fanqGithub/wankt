package com.fanqi.wankt.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fanqi.wankt.common.ServiceFactory
import com.fanqi.wankt.common.bean.DataHomeList
import com.fanqi.wankt.common.bean.DataX
import com.fanqi.wankt.utils.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//负责数据的获取绑定
class HomeViewModel : ViewModel() {

    private var currentPage = 0

    /*  MutableLiveData为一种容器，需要按照以下方法创建 */
    /* MutableLiveData中地数据无法直接赋值，
        需通过setValue或getaValue赋值或取值
        也可通过postValue
    */

    var homeData = MutableLiveData<List<DataX>>()

    var listDataX: List<DataX>? = null

    private fun getHomeList() {
        val call = ServiceFactory.INSTANCE.wanService.articleList(currentPage)
        call.enqueue(object : Callback<DataHomeList> {
            override fun onFailure(call: Call<DataHomeList>, t: Throwable) {
                Logger.e(t.toString())
            }

            override fun onResponse(call: Call<DataHomeList>, response: Response<DataHomeList>) {
                if (response.isSuccessful) {
                    val homeList = response.body()?.data
                    listDataX = homeList!!.datas
                    homeData.value=listDataX
//                    homeData.postValue(listDataX)
                }
            }

        })
    }

    fun initData() {
        currentPage = 0
        getHomeList()
    }

    fun nextPage() {
        ++currentPage
        getHomeList()
    }
}