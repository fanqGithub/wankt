package com.fanqi.wankt.common

import com.fanqi.wankt.common.bean.DataHomeList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by fanqi on 2019-12-19.
 * Description:
 */
interface WanService {

    @GET("/article/list/{page}/json")
    fun articleList(
        @Path("page") page: Int
    ):Call<DataHomeList>
}