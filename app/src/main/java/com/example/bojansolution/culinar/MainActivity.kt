package com.example.bojansolution.culinar

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.bojansolution.culinar.customer.CustomerController
import com.example.bojansolution.culinar.login.LoginController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById(R.id.curtnerBtnId) as Button
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginController::class.java)
            startActivity(intent)
        }

        val customerButton = findViewById(R.id.mainCustomerButton) as Button
        customerButton.setOnClickListener {
            val intent = Intent(this, CustomerController::class.java)
            startActivity(intent)
        }
    }
}