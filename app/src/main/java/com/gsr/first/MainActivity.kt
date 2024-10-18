package com.gsr.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// MainActivity is the entry point of your Android app
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the layout resource activity_main
        setContentView(R.layout.activity_main)

        var btn = findViewById<Button>(R.id.submit);
        var txt = findViewById<EditText>(R.id.userInput);
        var msg = findViewById<TextView>(R.id.label)

        btn.setOnClickListener {
            var name = txt.text.toString()
            name = "Welcome to the android ".plus(name)
            msg.text = name;
        }
    }
}
