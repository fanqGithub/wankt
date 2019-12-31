package com.fanqi.wankt.ui.collection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.fanqi.wankt.R

class MyCollectionsActivity : AppCompatActivity() {

    private lateinit var viewModel: MycollectionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_collections)

        viewModel = ViewModelProviders.of(this).get(MycollectionViewModel::class.java)
    }
}
