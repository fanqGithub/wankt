package com.fanqi.wankt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.fanqi.wankt.R
import com.fanqi.wankt.utils.Exit
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var userNameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginBtn: Button
    private lateinit var register: TextView
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        userNameEditText = userName
        passwordEditText = password
        loginBtn = loginBtn
        register = register

        loginBtn.setOnClickListener {
            val userName = userNameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            if (TextUtils.isEmpty(userName)) {
                Exit.toast("用户名不能为空", this@LoginActivity)
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                Exit.toast("密码不能为空", this@LoginActivity)
                return@setOnClickListener
            }
            loginViewModel.login(userName, password)
        }

        register.setOnClickListener {

        }
    }
}
