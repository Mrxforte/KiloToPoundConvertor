package com.example.kilotopoundconvertor

import android.os.Bundle
import android.text.Editable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kilotopoundconvertor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonConvert.setOnClickListener() {
            var inputText = binding.editText.text.toString()
            var kilo = inputText.toDouble()
            var pounds = kiloToPounds(kilo)
            binding.outPutText.text = "$inputText - Kg \nTo Pounds: ${pounds.toString()}"
        }
    }
}

fun kiloToPounds(kg: Double): Double {
    return kg * 20462
}