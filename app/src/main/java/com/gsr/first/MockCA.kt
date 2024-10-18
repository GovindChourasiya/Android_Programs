package com.gsr.first

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.Menu

class MockCA : AppCompatActivity() {

    private val predefinedCaseIds = listOf("01", "02", "03", "04", "05")
    private val caseData = mutableListOf<Pair<String, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mock_ca)

        val caseIdEditText: EditText = findViewById(R.id.caseId)
        val caseTypeSpinner: Spinner = findViewById(R.id.spinnerId)
        val checkBox: CheckBox = findViewById(R.id.checkboxId)
        val resultTextView: TextView = findViewById(R.id.resultId)
        val showButton: Button = findViewById(R.id.buttonId)

        val showMessage = findViewById<TextView>(R.id.intentId)
        val value = intent.extras?.getString("Hello ");
        showMessage.text = "Welcome "+value;

        val caseTypes = listOf("Select Case Type", "Civil", "Criminal", "Corporate", "Family")
        caseTypeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, caseTypes).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }



        showButton.setOnClickListener {
            val caseId = caseIdEditText.text.toString().trim()
            val selectedCaseType = caseTypeSpinner.selectedItem.toString()
            val isChecked = checkBox.isChecked

            Log.d("MockCA", "Case ID: $caseId, Case Type: $selectedCaseType, Checkbox: $isChecked")

            resultTextView.text = when {
                caseId.isEmpty() -> "Please enter a case ID"
                selectedCaseType == "Select Case Type" -> "Please select a case type"
                !isChecked -> "Please accept the terms and conditions"
                caseId !in predefinedCaseIds -> "Invalid Case ID. Please select a valid case ID (01, 02, 03, 04, 05)"
                else -> {
                    if (caseData.size >= 5) caseData.removeAt(0)
                    caseData.add(caseId to selectedCaseType)
                    "MockCA: Case ID: $caseId, Case Type: $selectedCaseType, Checkbox: $isChecked"
                }
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menubar, menu)
        return true
    }
}
