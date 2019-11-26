package com.example.myapplication1.ui.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.Data.remote.LoginApi.RemoteRepositoryRetrofitLogin
import com.example.myapplication1.Data.remote.LoginApi.RetrofitLoginFactory
import com.example.myapplication1.R
import com.example.myapplication1.ui.Register.RegisterActivity
import com.example.myapplication1.ui.MainActivity

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var usernameTxt: EditText
    private lateinit var passwordTxt: EditText
    private lateinit var loginBtn: Button
    private lateinit var clearBtn: Button
    private lateinit var registerBtn: Button
    private lateinit var skipBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameTxt = findViewById(R.id.usernameTxt)
        passwordTxt = findViewById(R.id.passwordTxt)
        loginBtn = findViewById(R.id.loginBtn)
        clearBtn = findViewById(R.id.clearBtn)
        registerBtn = findViewById(R.id.RegisterButton)
        skipBtn = findViewById(R.id.SkipButton)
        val remoteRepository =
            RemoteRepositoryRetrofitLogin(RetrofitLoginFactory.getLoginApi())
        val presenter = LoginPresenter(this, remoteRepository)

        loginBtn.setOnClickListener {

            val username = usernameTxt.text.toString()
            val password = passwordTxt.text.toString()
            presenter.onLoginClicked(username, password)
        }
        registerBtn.setOnClickListener {
            goToRegister()
        }
        clearBtn.setOnClickListener {
            presenter.onClearClicked()
        }
        skipBtn.setOnClickListener {
            goToSearch()
        }
        presenter.init()
    }

    override fun showLoginSuccessful() {
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
        goToSearch()
    }

    override fun showLoginError() {
        Toast.makeText(this, "Login error", Toast.LENGTH_SHORT).show()
        clearFields()

    }

    override fun showFieldRequiredError(emptyList: List<String>) {
        Toast.makeText(
            this,
            "The fields ${emptyList.joinToString()} are required",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun clearFields() {
        usernameTxt.text.clear()
        passwordTxt.text.clear()
    }

    override fun goToSearch() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun goToRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
        finish()
    }
}