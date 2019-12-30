package com.fanqi.wankt.ui.mine

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.lifecycle.Observer

import com.fanqi.wankt.R
import com.fanqi.wankt.ui.login.LoginActivity
import com.fanqi.wankt.utils.toast
import kotlinx.android.synthetic.main.mine_fragment.*

class MineFragment : Fragment(), View.OnClickListener {

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.userName -> {
                if (userNameTv.text.equals("点击登录")) {
                    Intent(activity, LoginActivity::class.java).run {
                        startActivity(this)
                    }
                }
            }
        }
    }

    private lateinit var mineViewModel: MineViewModel
    private lateinit var userNameTv: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mineViewModel =
            ViewModelProviders.of(this).get(MineViewModel::class.java)
        val root = inflater.inflate(R.layout.mine_fragment, container, false)

        userNameTv = root.findViewById(R.id.userName)
        userNameTv.setOnClickListener(this)

        setStatusColor(resources.getColor(R.color.colorAccent))
        mineViewModel.initUserData()
        mineViewModel.mineData.observe(this, Observer {
            if (!it.userName.isEmpty()) {
                userNameTv.text = it.userName
            } else {
                userNameTv.text = "点击登录"
            }
        })
        return root
    }

    fun setStatusColor(color: Int) {
        val window = activity?.getWindow()
        window!!.statusBarColor = color
    }

}
