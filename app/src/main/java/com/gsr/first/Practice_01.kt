package com.gsr.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class Practice_01 : AppCompatActivity() {

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice01)

        val txt2 = findViewById<TextView>(R.id.textView)
        val spin = findViewById<Spinner>(R.id.coursesSpinner)

        val languages = arrayOf("Java","Kotlin","Python","Perl","Android")

        spin?.apply {
            adapter = ArrayAdapter(this@Practice_01,android.R.layout.simple_spinner_item,languages)

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedLanguage = languages[position]
                    txt2.text = "Selected: $selectedLanguage"
                    Toast.makeText(this@Practice_01,"Selected Item : $selectedLanguage",Toast.LENGTH_SHORT).show();
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}