package com.fanqi.wankt.common

import com.fanqi.wankt.common.bean.*
import retrofit2.Call
import retrofit2.http.*

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


    //常用网站
    @GET("/friend/json")
    fun friendData(): Call<FriendRespons>

    //热搜关键词
    @GET("/hotkey/json")
    fun hotKey(): Call<FriendRespons>

    //登录
    @FormUrlEncoded
    @POST("/user/login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<Any>


    //注册
    @FormUrlEncoded
    @POST("/user/register")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): Call<Any>

}