package com.gsr.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class Practice_02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice02)

        val spin = findViewById<Spinner>(R.id.coursesSpinner)
        val textV = findViewById<TextView>(R.id.textView)

        val languages = arrayOf("Java","Python","Kotlin")

        spin?.apply {
            adapter = ArrayAdapter(this@Practice_02,android.R.layout.simple_spinner_item,languages)

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selected = languages[position]
                    textV.text = "Selected language: $selected"
                    Toast.makeText(this@Practice_02,"Changes made",Toast.LENGTH_SHORT).show()

                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}