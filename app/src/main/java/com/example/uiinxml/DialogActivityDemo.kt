package com.example.uiinxml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uiinxml.databinding.ActivityMainBinding

class DialogActivityDemo : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}