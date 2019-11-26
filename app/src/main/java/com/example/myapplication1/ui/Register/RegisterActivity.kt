package com.example.myapplication1.ui.Register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.Data.remote.LoginApi.Register.RemoteRepositoryRetrofitRegister
import com.example.myapplication1.Data.remote.LoginApi.RetrofitLoginFactory
import com.example.myapplication1.R
import com.example.myapplication1.ui.Login.LoginActivity


class RegisterActivity : AppCompatActivity(), registerView {
    override fun showRegisterErrors() {
        Toast.makeText(this, "Error ", Toast.LENGTH_SHORT).show()

    }

    private lateinit var usernameTxt: EditText
    private lateinit var passwordTxt: EditText
    private lateinit var email: EditText
    private lateinit var registerBtn: Button

    override fun showRegisterSuccessful() {

        Toast.makeText(this, "Register successful", Toast.LENGTH_SHORT).show()
        goToSearch()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        usernameTxt = findViewById(R.id.usernameTxt)
        passwordTxt = findViewById(R.id.passwordTxt)
        email = findViewById(R.id.email)
        registerBtn = findViewById(R.id.registerBtn)
        val remoteRepository =
            RemoteRepositoryRetrofitRegister(RetrofitLoginFactory.getLoginApi())
        val presenter =
            RegisterPresenter(this, remoteRepository)

        registerBtn.setOnClickListener {
            val username = usernameTxt.text.toString()
            val password = passwordTxt.text.toString()
            val email = email.text.toString()

            presenter.onRegisterClicked(username, password, email)
        }

    }

    fun goToSearch() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
