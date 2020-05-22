package com.example.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*
import kotlinx.android.synthetic.main.user_registration.email

class MainActivity : AppCompatActivity() {

    lateinit var handler: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = SharedPreferences( this)

        showHome()

        registration.setOnClickListener {
            showRegistration()
        }

        login.setOnClickListener {
            showLogin()
        }

        save.setOnClickListener {
            handler.insertUserData(имя.text.toString(), email.text.toString(), пароль.text.toString())
            showHome()
        }

        войти.setOnClickListener {
            if (handler.userPresent(email.text.toString(), пароль.text.toString()))
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
        }

    }

    private fun showRegistration(){
        registration_layout.visibility = View.VISIBLE
        login_layout.visibility = View.GONE
        home_11.visibility = View.GONE
    }

    private fun showLogin(){
        registration_layout.visibility = View.GONE
        login_layout.visibility = View.VISIBLE
        home_11.visibility = View.GONE
    }

    private fun showHome(){
        registration_layout.visibility = View.GONE
        login_layout.visibility = View.GONE
        home_11.visibility = View.VISIBLE
    }
}
