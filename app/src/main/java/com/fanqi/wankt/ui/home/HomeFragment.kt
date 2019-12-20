package com.fanqi.wankt.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fanqi.wankt.R
import com.fanqi.wankt.common.ServiceFactory
import com.fanqi.wankt.common.bean.DataX
import com.fanqi.wankt.utils.Logger
import retrofit2.Callback


//https://androidwave.com/android-paging-library/
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var listData: ArrayList<DataX>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                //Fragment绑定ViewModel , of(getActivity())与of(this)的区别
                //mViewModel = ViewModelProviders.of(getActivity()).get(DemoViewModel.class);
                // 使用getActivity()获得的ViewModel 作用域在Activity里和所有他创建碎片的里,意思是你在其他Fragment也获取相同内存地址的ViewModel
                //mViewModel = ViewModelProviders.of(this).get(DemoViewModel.class);
                // 这个ViewModel是独立的,只为这个Fragment单独服务,其他Fragment无法获取到相同内存地址的ViewModel
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        recyclerView = root.findViewById(R.id.recycler_view)
        init()

        homeViewModel.initData()

        //写法一
        homeViewModel.homeData.observe(this, Observer {
            listData.addAll(it)
            homeAdapter.notifyDataSetChanged()
            Logger.d(listData.size.toString())
        })

        //写法二：完整的写，应该是这样的
//        homeViewModel.homeData.observe(this,object :Observer<List<DataX>>{
//            override fun onChanged(t: List<DataX>?) {
//
//            }
//
//        })

        return root
    }

    fun init() {
        var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        listData = arrayListOf()
        homeAdapter = context?.let { HomeAdapter(listData, it) }!!
        recyclerView.adapter = homeAdapter
    }


}