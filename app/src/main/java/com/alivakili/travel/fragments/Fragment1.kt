package com.alivakili.travel.fragments

import android.content.Intent
import com.alivakili.travel.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.alivakili.travel.activities.MainActivity2


class Fragment1: Fragment() {
    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = inflater.inflate(R.layout.layout_fragment1, container, false)
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.skipBtn).setOnClickListener(View.OnClickListener {
            navigateToActivity()

        })
    }
    fun navigateToActivity() {
        val intent = Intent(requireContext(), MainActivity2::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

}
