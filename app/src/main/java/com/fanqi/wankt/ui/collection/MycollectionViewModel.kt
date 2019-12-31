package com.fanqi.wankt.ui.collection

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fanqi.wankt.common.ServiceFactory
import com.fanqi.wankt.common.bean.Collection
import com.fanqi.wankt.common.bean.CollectionPageData
import com.fanqi.wankt.common.bean.Response
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by fanqi on 2019-12-31.
 * Description:
 */
class MycollectionViewModel : ViewModel() {

    var collectionsLiveData = MutableLiveData<List<Collection>>()


    fun collections() {
        val call = ServiceFactory.INSTANCE.wanService.collectionList(currentPage)
        call.enqueue(object : Callback<Response<CollectionPageData>> {
            override fun onFailure(call: Call<Response<CollectionPageData>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<Response<CollectionPageData>>,
                response: retrofit2.Response<Response<CollectionPageData>>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null && responseBody.errorCode == 0) {
                        val list = responseBody.data.datas

                    }
                }
            }
        })
    }

    var currentPage = 1

    fun initPage(cid: Int) {
        currentPage = 1
        collections()
    }

    fun nextPage(cid: Int) {
        ++currentPage
        collections()
    }

}