package com.gsr.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class Snackbar_Demo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar_demo)

        val userId: EditText = findViewById(R.id.username)
        val passwordId: EditText = findViewById(R.id.password)
        val loginBtn: Button = findViewById(R.id.login)
        val resetBtn: Button = findViewById(R.id.reset)

        // Store the original username and password
        var originalUsername = ""
        var originalPassword = ""

        resetBtn.setOnClickListener {
            // Save the current values before resetting
            originalUsername = userId.text.toString()
            originalPassword = passwordId.text.toString()

            // Clear the username and password fields
            userId.setText("")
            passwordId.setText("")

            // Show Snackbar with Undo action
            val snackbar = Snackbar.make(resetBtn, "Username and Password reset", Snackbar.LENGTH_LONG)
            snackbar.duration = 10000
            snackbar.setAction("Undo") {
                // Restore original values if Undo is clicked
                userId.setText(originalUsername)
                passwordId.setText(originalPassword)
            }
            snackbar.show()
        }
    }
}
