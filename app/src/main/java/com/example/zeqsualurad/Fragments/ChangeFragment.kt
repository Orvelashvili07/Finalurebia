package com.example.zeqsualurad.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zeqsualurad.R
import com.google.firebase.auth.FirebaseAuth

class ChangeFragment: Fragment(R.layout.change_password) {


    private lateinit var editTextPassword: EditText
    private lateinit var buttonPasswordChange: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        registerListeners()

    }

    private fun init(view: View){
        editTextPassword = view.findViewById(R.id.editTextPassword)
        buttonPasswordChange = view.findViewById(R.id.buttonPasswordChange)
    }


    private fun registerListeners(){
        buttonPasswordChange.setOnClickListener(){

            val newPassword = editTextPassword.text.toString()

            if (newPassword.isEmpty() || newPassword.length > 6){
                Toast.makeText(requireActivity(), "The password requires at least 6 characters ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(requireActivity(), "Successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireActivity(), "Unsuccessful", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }

}