package com.gsr.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Spinner

class PizzaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza)

        val spinnerItems = listOf("Pizza","Noodles");

        val courseSpinner: Spinner = findViewById(R.id.spinnerId)
        val listView: ListView = findViewById(R.id.listView)


    }
}