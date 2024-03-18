package com.example.uiinxml

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.uiinxml.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logLifeCycle("onCreate")

        val str = intent.getStringExtra("Message")

        binding.tvTitle.setOnClickListener {
            setResult(RESULT_OK,intent.apply {
                putExtra("SecondActivity","Data From SecondActivity")
            })
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        logLifeCycle("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        logLifeCycle("onRestart")
    }
    override fun onResume() {
        super.onResume()
        logLifeCycle("onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifeCycle("onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifeCycle("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifeCycle("onDestroy")
    }

    private fun logLifeCycle(msg: String){
        Log.d("SecondActivity",msg)
    }
}