package com.example.myapplication1.ui.Register

import com.example.myapplication1.Data.remote.LoginApi.Register.RemoteRepositoryRegister
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RegisterPresenter(
    private val view: registerView,
    private val remoteRepositoryRegister: RemoteRepositoryRegister
) {

    fun onRegisterClicked(username: String, password: String, email: String) {
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            val emptyList = mutableListOf<String>()
            if (username.isEmpty()) {
                emptyList.add("username")
            }
            if (password.isEmpty()) {
                emptyList.add("password")
            }
            return
        }
        CoroutineScope(Dispatchers.IO).launch {
            val loggedUser = remoteRepositoryRegister.register(username, password, email)
            println(loggedUser.message)
            if (loggedUser.message == "User created") {
                withContext(Dispatchers.Main) {
                    view.showRegisterSuccessful()
                }
            } else {
                withContext(Dispatchers.Main) {
                    view.showRegisterErrors()
                }
            }
        }
    }
}

interface registerView {
    fun showRegisterSuccessful()
    fun showRegisterErrors()

}