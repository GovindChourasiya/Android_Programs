package com.gsr.first

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SpinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        // Initialize the Spinner
        val courseSpinner: Spinner = findViewById(R.id.course)

        // Create a list of courses or items to display in the Spinner
        val courses = listOf("Mathematics", "Science", "History", "English", "Computer Science")

        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, courses)

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the Spinner
        courseSpinner.adapter = adapter

        // Set an item selected listener for the Spinner
        courseSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Get the selected item and show a toast message
                val selectedCourse = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@SpinnerActivity, "Selected: $selectedCourse", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing if no item is selected
            }
        }
    }
}
