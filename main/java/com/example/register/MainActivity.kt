package com.example.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showHome()

        registration.setOnClickListener {
            showRegistration()
        }

        login.setOnClickListener {
            showLogin()
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
