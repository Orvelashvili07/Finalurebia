package com.example.zeqsualurad.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zeqsualurad.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment: Fragment(R.layout.register_fragment) {

    private lateinit var bottomRegister: Button
    private lateinit var bottomLogin: Button
    private lateinit var loginPassword2: TextInputEditText
    private lateinit var loginEmail2: TextInputEditText
    private lateinit var loginName: TextInputEditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        registerListeners()



    }
    private fun init(view: View){
        bottomRegister = view.findViewById(R.id.bottomRegister)
        bottomLogin = view.findViewById(R.id.bottomLogin)
        loginPassword2 = view.findViewById(R.id.loginPassword2)
        loginEmail2 = view.findViewById(R.id.loginEmail2)
        loginName = view.findViewById(R.id.loginName)

    }


    private fun registerListeners(){
        bottomLogin.setOnClickListener{
            startActivity(Intent(requireActivity(), LoginFragment::class.java))
        }
        bottomRegister.setOnClickListener{
            val email = loginEmail2.text.toString()
            val password = loginPassword2.text.toString()

            if(email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireActivity(), "Email or password is blank", Toast.LENGTH_SHORT).show()
                return@setOnClickListener


            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword( email, password)

                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        val intent = Intent(activity, LoginFragment::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(requireActivity(), "The operation failed", Toast.LENGTH_SHORT).show()
                    }
                }


        }
    }

}