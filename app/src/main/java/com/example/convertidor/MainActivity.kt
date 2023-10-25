package com.example.convertidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var temperature: String = ""
    private var selectedOption: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val reult = findViewById<TextView>(R.id.textView2)
        val option = findViewById<Spinner>(R.id.spinner)
        val temo = findViewById<EditText>(R.id.editTextText)
        val button = findViewById<Button>(R.id.buttonconvertir)

        button.setOnClickListener{
            temperature = temo.text.toString()

            conversion(selectedOption)


        }
        if (option!= null) {

            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.convert_option)


            )
            option.adapter = adapter

            option.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    selectedOption = p2

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
                }
        }


    }

    private fun conversion(option: Int) {
        val temperatureValue = temperature.toDoubleOrNull() ?: return
        var result: Double = 0.0

        when (option) {
            0 -> {
                //Aqui meter las formulas
                result = (temperatureValue * 9/5) + 32
            }
            1 -> {
                result = temperatureValue + 273.15

            }
            2 -> {
                result = (temperatureValue - 32) * 5/9

            }
            3 -> {
                result = (temperatureValue + 459.67) * 5/9

            }
            4 -> {
                result = temperatureValue - 273.15
            }
            5 -> {
                result = (temperatureValue * 9/5) - 459.67

            }
        }
        val resultTextView = findViewById<TextView>(R.id.textView2)
        resultTextView.text = "Resultado: $result"
    }
}