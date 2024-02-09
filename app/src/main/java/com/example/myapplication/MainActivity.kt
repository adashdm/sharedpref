package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var counterTextView: TextView
    private lateinit var button: Button
    private lateinit var sharedPreferences: SharedPreferences

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterTextView = findViewById(R.id.counterTextView)
        button = findViewById(R.id.button)
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        counter = sharedPreferences.getInt("keyCounter", 0)
        counterTextView.text = counter.toString()
        button.setOnClickListener {
            counter++
            counterTextView.text = counter.toString()
            with(sharedPreferences.edit()) {
                putInt("keyCounter", counter)
                apply()
            }
            Toast.makeText(this, "Додано до лічильника", Toast.LENGTH_SHORT).show()
        }
    }
}