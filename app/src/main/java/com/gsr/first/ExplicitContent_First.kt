package com.gsr.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText

class ExplicitContent_First : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_content_first)

        // Find views
        val buttonId = findViewById<Button>(R.id.button1)
        val userId = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.userPassword)

        // Set onClick listener for the button
        buttonId.setOnClickListener {
            val myIntent = Intent(this, MockCA::class.java)

            // Get user input from the EditText fields
            val name = userId.text.toString()
            val pass = password.text.toString()

            // Pass the name and password to the next activity
            myIntent.putExtra("name", name)
            myIntent.putExtra("password", pass)

            // Start the new activity
            startActivity(myIntent)
        }
    }

    // Move this outside the onCreate method
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menubar, menu)
        return true
    }
}
