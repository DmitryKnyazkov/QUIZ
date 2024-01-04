package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.quiz.databinding.ActivityMainBinding
import android.Manifest

class MainActivity : AppCompatActivity() {
    var inet = false
    private val launcher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            it -> if (it) { inet = true }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launcher.launch(Manifest.permission.INTERNET)
        binding.button.setOnClickListener {
            if (binding.button.text == "ДА!!!") {
                binding.button.text = "НЕТ!!!"
            } else {
                binding.button.text = "ДА!!!"
            }
        }

        if (inet) {binding.textView.text = "Интернет есть"}
    }
}