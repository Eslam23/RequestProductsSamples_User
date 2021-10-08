package com.example.productssamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class SubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.let{
            val adapter = ArrayAdapter(this@SubmitActivity,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.departments))
            it.adapter = adapter
        }
    }
}