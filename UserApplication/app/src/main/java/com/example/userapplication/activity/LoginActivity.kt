package com.example.userapplication.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.userapplication.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<Button>(R.id.loginbutton)

        val sharedPref = getSharedPreferences("username", Context.MODE_PRIVATE)
        val usernamee = sharedPref.getString("username", "")
        if (usernamee?.isNotEmpty() == true) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }

        login.setOnClickListener {
            val username = findViewById<EditText>(R.id.username).text


            with(sharedPref.edit()) {
                putString("username", username.toString())
                apply()

                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()

            }

        }

    }
}