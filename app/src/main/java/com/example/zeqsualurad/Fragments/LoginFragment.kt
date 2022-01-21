package com.example.zeqsualurad.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zeqsualurad.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LoginFragment: Fragment(R.layout.login_fragment) {

    private lateinit var login2: Button
    private lateinit var registerPassword: TextInputEditText
    private lateinit var registerEmail: TextInputEditText
    private lateinit var register2: Button
    private lateinit var reset: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (FirebaseAuth.getInstance().currentUser != null) {
            startActivity(Intent(requireContext(), HomeFragment::class.java))
            requireActivity().finish()
        }
        registerListeners()
        init(view)



    }



    private fun registerListeners() {
        login2.setOnClickListener() {
            val email = registerEmail.text.toString()
            val password = registerPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireActivity(), "Email or Password is Blanck", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(activity, HomeFragment::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(requireActivity(), "Registration is Unsuccsesful", Toast.LENGTH_SHORT).show()
                    }
                }

        }
        register2.setOnClickListener() {
            val intent = Intent(requireActivity(), RegisterFragment::class.java)
            startActivity(intent)

        }
        reset.setOnClickListener(){
            val intent = Intent(requireActivity(), ResetFragment::class.java)
            startActivity(intent)

        }



    }


    private fun init(view: View){
        login2 = view.findViewById(R.id.login2)
        registerPassword = view.findViewById(R.id.registerPassword)
        registerEmail = view.findViewById(R.id.registerEmail)
        register2 = view.findViewById(R.id.register2)
        reset = view.findViewById(R.id.reset)

    }




}