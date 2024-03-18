package com.example.uiinxml.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.uiinxml.R
import com.example.uiinxml.databinding.FragmentSecondBinding

class SecondFragment : BaseFragments() {
    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        debugLog("onCreate: ids=${requireArguments()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        debugLog("onCreateView")
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView2.setOnClickListener {
            parentFragmentManager.commit {
                replace<SecondFragment>(
                    containerViewId = R.id.fragment_container_view_1,
                    tag = "ThirdFragment",
                    args = Bundle().apply {
                        putInt("count", 42)
                        putString("name", "John Doe")
                        putStringArrayList("ids", arrayListOf("1", "2", "3"))
                    }
                )
                setReorderingAllowed(true)

                addToBackStack("second-to-third")
            }
        }
    }


    override fun onDestroyView() {
        _binding = null // Avoid memory leak
        super.onDestroyView()
    }
}
