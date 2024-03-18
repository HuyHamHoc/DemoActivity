package com.example.uiinxml.fragments

import android.content.Context
import android.media.MediaDrm.LogMessage
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment

abstract class BaseFragments : Fragment() {
    private val logTag = this::class.java.simpleName

    protected fun debugLog(message: String){
        Log.d(logTag,"$this: $message" )
    }

    @CallSuper
    override fun onAttach(context: Context) {
        super.onAttach(context)
        debugLog("onAttach: context=$context")
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        debugLog("onCreate: savedInstanceState=$savedInstanceState")
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        debugLog("onViewCreate: view=$view, savedInstanceState=$savedInstanceState")
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        debugLog("onStart")
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        debugLog("onResume")
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        debugLog("onStart")
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        debugLog("onStop")
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        debugLog("onDestroyView")
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        debugLog("onDestroy")
    }

    @CallSuper
    override fun onDetach() {
        super.onDetach()
        debugLog("onDetach")
    }
}