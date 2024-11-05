package com.example.lab5

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SecondFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logLifecycle()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logLifecycle()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logLifecycle()
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logLifecycle()
    }

    override fun onStart() {
        super.onStart()
        logLifecycle()
    }

    override fun onResume() {
        super.onResume()
        logLifecycle()
    }

    override fun onPause() {
        super.onPause()
        logLifecycle()
    }

    override fun onStop() {
        super.onStop()
        logLifecycle()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logLifecycle()
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycle()
    }

    override fun onDetach() {
        super.onDetach()
        logLifecycle()
    }
}

