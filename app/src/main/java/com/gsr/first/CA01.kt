package com.gsr.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class CA01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ca01)

        val NumberId = findViewById<EditText>(R.id.accountNumber)
        val PasswordId = findViewById<EditText>(R.id.accountPassword)
        val CheckboxId = findViewById<CheckBox>(R.id.CheckboxId)
        val ButtonId = findViewById<Button>(R.id.ButtonId)
        val resId = findViewById<TextView>(R.id.ResultId)

        ButtonId.setOnClickListener {
            val passwordInput = PasswordId.text.toString()

            if (!CheckboxId.isChecked) {
                resId.text = "Please mark the checkbox."
            } else {
                if (passwordInput == "HB123") {
                    resId.text = "Validation successful!"
                } else {
                    resId.text = "Invalid password."
                }
            }
        }
    }
}
