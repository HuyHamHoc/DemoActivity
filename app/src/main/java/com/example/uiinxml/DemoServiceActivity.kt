package com.example.uiinxml

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.uiinxml.databinding.ActivityDemoServiceBinding
import com.example.uiinxml.services.MyForegroundService

class DemoServiceActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDemoServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener {
            ContextCompat.startForegroundService(
                this,
                Intent(this, MyForegroundService::class.java).apply {
                    putExtra(MyForegroundService.ACTION_EXTRA_KEY, "START")
                }
            )
        }
        binding.buttonStop.setOnClickListener {
            this.stopService(Intent(this, MyForegroundService::class.java))
        }
    }
}