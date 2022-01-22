package com.example.zeqsualurad.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.zeqsualurad.R
import com.example.zeqsualurad.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class ProfileFragment: Fragment(R.layout.profile) {
    private lateinit var LogOut: Button
    private lateinit var person: ImageView
    private lateinit var NameUsername: TextView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)





    }
    private fun init(view: View){
        LogOut = view.findViewById(R.id.Logout)
        NameUsername = view.findViewById(R.id.NameUsername)
        person = view.findViewById(R.id.person)
    }







}