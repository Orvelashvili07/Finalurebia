package com.example.zeqsualurad.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zeqsualurad.R
import com.google.firebase.auth.FirebaseAuth

class ResetFragment: Fragment(R.layout.reset_password) {

    private lateinit var editTextEmail: EditText
    private lateinit var buttonSendEmail: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        registerListeners()


    }

    private fun init(view: View){
        editTextEmail = view.findViewById(R.id.editTextEmail)
        buttonSendEmail = view.findViewById(R.id.buttonSendEmail)
    }
    private fun registerListeners(){
        buttonSendEmail.setOnClickListener{
            val email = editTextEmail.text.toString()
            if (email.isEmpty()){
                Toast.makeText(requireActivity(), "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(requireActivity(), "Check Email!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireActivity(), "Something's Wrong", Toast.LENGTH_SHORT).show()
                    }
                }


        }
    }


}