package com.example.bojansolution.culinar.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bojansolution.culinar.R

/**
 * Created by bojan solution on 27/03/2018.
 */

class LoginController : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // get reference to all views
        var editTextUsername = findViewById(R.id.loginEditTextUsername) as EditText
        var editTextPassword = findViewById(R.id.loginEditTextPassword) as EditText
        var buttonReset = findViewById(R.id.loginButtonReset) as Button
        var buttonSubmit = findViewById(R.id.loginButtonSubmit) as Button


        val extra = intent.extras
        if(null != extra) {
            editTextUsername.setText(extra.getString("text"))
        }

        buttonReset.setOnClickListener {
            editTextUsername.setText("")
            editTextPassword.setText("")
        }

        buttonSubmit.setOnClickListener {
            val userName = editTextUsername.text
            val password = editTextPassword.text
            Toast.makeText(this@LoginController, userName, Toast.LENGTH_LONG).show()
        }
    }
}