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
        val temeratura = temperature.toDoubleOrNull() ?: return
        var resultado: Double = 0.0
        var unidad: String = ""

        when (option) {
            0 -> {
                //Aqui meter las formulas
                resultado = (temeratura * 9/5) + 32
                unidad = "°F"
            }
            1 -> {
                resultado = temeratura + 273.15
                unidad = "°K"

            }
            2 -> {
                resultado = (temeratura - 32) * 5/9
                unidad = "°C"

            }
            3 -> {
                resultado = (temeratura + 459.67) * 5/9
                unidad = "°K"

            }
            4 -> {
                resultado = temeratura - 273.15
                unidad = "°C"
            }
            5 -> {
                resultado = (temeratura * 9/5) - 459.67
                unidad = "°F"

            }
        }
        val resultTextView = findViewById<TextView>(R.id.textView2)
        resultTextView.text = "Resultado: $resultado $unidad"
    }
}