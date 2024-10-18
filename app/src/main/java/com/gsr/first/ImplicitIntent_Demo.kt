package com.gsr.first

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class ImplicitIntent_Demo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent_demo)

        val dialBtn: Button = findViewById(R.id.dial)
        val phoneNum: EditText = findViewById(R.id.phone)
        val searchBtn: Button = findViewById(R.id.search)
        val urlLink: EditText = findViewById(R.id.urlLink)
        val cameraId : Button = findViewById(R.id.camera)
        val snackId : Button = findViewById(R.id.snackbar)

        dialBtn.setOnClickListener {
            val num = phoneNum.text.toString().trim()

            if (num.isNotEmpty()) {
                // Proceed with the intent only if phone number is valid
                val myIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(num)))
                startActivity(myIntent)
            } else {
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
            }
        }

        cameraId.setOnClickListener {
            val camIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(camIntent)
        }

        snackId.setOnClickListener {
            val snackb = Snackbar.make(snackId,"Snackbar is displaying message",Snackbar.LENGTH_INDEFINITE)
                .setAction("Cancel"){}

            snackb.show()
        }

        searchBtn.setOnClickListener {
            val myUrl = urlLink.text.toString().trim()

            if (myUrl.isNotEmpty() && (myUrl.startsWith("http://") || myUrl.startsWith("https://"))) {
                val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(myUrl))
                startActivity(urlIntent)
            } else {
                Toast.makeText(this, "Please enter a valid URL", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
