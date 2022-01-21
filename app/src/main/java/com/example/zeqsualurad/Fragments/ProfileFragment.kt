package com.example.zeqsualurad.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.zeqsualurad.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileFragment: Fragment(R.layout.profile) {
    private lateinit var LogOut: Button
    private lateinit var person: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        LogOut.setOnClickListener {
            Firebase.auth.signOut()
            val  intent = Intent(requireActivity(), LoginFragment::class.java)
            startActivity(intent)
            requireActivity().finish()
        }



    }
    private fun init(view: View){
        LogOut = view.findViewById(R.id.LogOut)
        person = view.findViewById(R.id.person)
    }









}