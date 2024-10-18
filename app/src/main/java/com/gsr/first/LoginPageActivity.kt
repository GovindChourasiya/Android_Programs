package com.gsr.first

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        // Initialize the views
        val userIdEditText: EditText = findViewById(R.id.userId)
        val passwordEditText: EditText = findViewById(R.id.password)
        val submitButton: Button = findViewById(R.id.submit)

        // Set click listener for submit button
        submitButton.setOnClickListener {
            val userId = userIdEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (userId.isNotEmpty() && password.isNotEmpty()) {
                // Handle login logic here
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter both User ID and Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
