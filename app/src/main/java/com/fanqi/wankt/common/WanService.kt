package com.fanqi.wankt.common

import com.fanqi.wankt.common.bean.BannerRespons
import com.fanqi.wankt.common.bean.DataHomeList
import com.fanqi.wankt.common.bean.ProjectListRespons
import com.fanqi.wankt.common.bean.ProjectTreeRespons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by fanqi on 2019-12-19.
 * Description:
 */
interface WanService {

    //首页
    @GET("/article/list/{page}/json")
    fun articleList(
        @Path("page") page: Int
    ): Call<DataHomeList>

    //首页banner
    @GET("/banner/json")
    fun banner(): Call<BannerRespons>

    //项目分类
    @GET("/project/tree/json")
    fun projectTree(): Call<ProjectTreeRespons>

    //项目列表
    @GET("/project/list/{page}/json")
    fun projectList(
        @Path("page") page: Int,
        @Query("cid") cid: Int
    ): Call<ProjectListRespons>
}