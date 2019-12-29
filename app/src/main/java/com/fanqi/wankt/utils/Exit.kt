package com.fanqi.wankt.utils

import android.content.Context
import android.widget.Toast

/**
 * @author:范启
 * Created on 2019-12-29.
 * Description:
 */
object Exit {

    fun toast(msg: String, context: Context) {
        Toast.makeText(context.applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}