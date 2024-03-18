package com.example.uiinxml.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.uiinxml.R
import com.example.uiinxml.databinding.FragmentFirstBinding

class FirstFragment : BaseFragments() {
    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        debugLog("onCreate: args=$args")
        debugLog("onCreate: count=${args.getInt("count")}")
        debugLog("onCreate: name=${args.getString("name")}")
        debugLog("onCreate: ids=${args.getStringArrayList("ids")}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        debugLog("onCreateView")
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView2.setOnClickListener {
            parentFragmentManager.commit {
                replace<SecondFragment>(
                    containerViewId = R.id.fragment_container_view_1,
                    tag ="SecondFragment",
                    args = Bundle().apply {
                        putInt("count", 42)
                        putString("name","John Doe")
                        putStringArrayList("ids", arrayListOf("1","2","3"))
                    }
                )
            setReorderingAllowed(true)
                addToBackStack("first-to-second")
            }
        }
    }

    override fun onDestroyView() {
        _binding = null // Avoid memory leak
        super.onDestroyView()
    }
}
