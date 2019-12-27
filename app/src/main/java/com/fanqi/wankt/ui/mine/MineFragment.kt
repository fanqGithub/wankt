package com.fanqi.wankt.ui.mine

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer

import com.fanqi.wankt.R

class MineFragment : Fragment() {

    private lateinit var mineViewModel: MineViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mineViewModel =
            ViewModelProviders.of(this).get(MineViewModel::class.java)
        val root = inflater.inflate(R.layout.mine_fragment, container, false)
        setStatusColor(resources.getColor(R.color.colorAccent))
        mineViewModel.init()
        mineViewModel.mineData.observe(this, Observer {

        })
        return root
    }

    fun setStatusColor(color: Int) {
        val window = activity?.getWindow()
        window!!.statusBarColor = color
    }

}
