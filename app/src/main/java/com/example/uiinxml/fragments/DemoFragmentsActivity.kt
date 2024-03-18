package com.example.uiinxml.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.uiinxml.R
import com.example.uiinxml.databinding.ActivityDemoFragmentsBinding

class DemoFragmentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoFragmentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState === null){
            supportFragmentManager.commit {
                replace<FirstFragment>(containerViewId = R.id.fragment_container_view_1,
                    tag = "FirstFragment",
                    args = bundleOf(
                        "count" to 0,
                        "name" to "huy",
                        "ids" to arrayListOf("id1", "id2")
                    )
                )
                setReorderingAllowed(true)
                addToBackStack("FirstFragment")
            }
        }
    }
}