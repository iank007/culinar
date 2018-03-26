package com.example.bojansolution.culinar

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.bojansolution.culinar.login.LoginController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.curtnerBtnId) as Button
        button.setOnClickListener {
            val intent = Intent(this, LoginController::class.java)
            val searchText = findViewById(R.id.textSearchStore) as EditText
            intent.putExtra("text", searchText.text)
            startActivity(intent)
        }
    }
}