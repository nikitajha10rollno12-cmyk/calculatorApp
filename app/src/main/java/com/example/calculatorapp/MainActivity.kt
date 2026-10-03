package com.example.calculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        tvResult = findViewById(R.id.tvResult)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivide: Button = findViewById(R.id.btnDivide)
        val btnClear: Button = findViewById(R.id.btnClear)

        btnAdd.setOnClickListener {
            calculate("+")
        }

        btnSubtract.setOnClickListener {
            calculate("-")
        }

        btnMultiply.setOnClickListener {
            calculate("*")
        }

        btnDivide.setOnClickListener {
            calculate("/")
        }

        btnClear.setOnClickListener {
            clearCalculator()
        }
    }

    private fun calculate(operation: String) {

        val number1Text = etNumber1.text.toString().trim()
        val number2Text = etNumber2.text.toString().trim()

        // Validate input
        if (number1Text.isEmpty() || number2Text.isEmpty()) {
            Toast.makeText(
                this,
                "Please enter both numbers",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        try {

            val number1 = number1Text.toDouble()
            val number2 = number2Text.toDouble()

            val result: Double

            when (operation) {

                "+" -> {
                    result = number1 + number2
                }

                "-" -> {
                    result = number1 - number2
                }

                "*" -> {
                    result = number1 * number2
                }

                "/" -> {

                    // Division by zero
                    if (number2 == 0.0) {
                        tvResult.text = "Result: Cannot divide by zero"

                        Toast.makeText(
                            this,
                            "Cannot divide by zero",
                            Toast.LENGTH_SHORT
                        ).show()

                        return
                    }

                    result = number1 / number2
                }

                else -> {
                    return
                }
            }

            tvResult.text = "Result: $result"

        } catch (e: NumberFormatException) {

            Toast.makeText(
                this,
                "Invalid number",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun clearCalculator() {

        etNumber1.text.clear()
        etNumber2.text.clear()

        tvResult.text = "Result: 0"

        Toast.makeText(
            this,
            "Calculator cleared",
            Toast.LENGTH_SHORT
        ).show()
    }
}