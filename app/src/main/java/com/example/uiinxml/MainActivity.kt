package com.example.uiinxml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.uiinxml.databinding.ActivityDialogDemoBinding
import com.example.uiinxml.databinding.ActivityMainBinding
import com.example.uiinxml.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logLifeCycle("onCreate")
        binding.btnClick.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java).apply {
                putExtra("Message","Đây là dữ liệu mới")
            }
            resultLauncher.launch(intent)
        }
    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        if (result.resultCode == RESULT_OK){
            val data = result.data
            val message = data?.getStringExtra("SecondActivity")

            binding.tvShowDialog.text = message
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
        Log.d("MainActivity",msg)
    }

}