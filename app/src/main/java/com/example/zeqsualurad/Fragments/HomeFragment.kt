package com.example.zeqsualurad.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zeqsualurad.FoodInfoActivity
import com.example.zeqsualurad.R
import com.example.zeqsualurad.adapter.FoodAdapter
import com.example.zeqsualurad.model.Food
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFragment: Fragment(R.layout.home_fragment), FoodAdapter.OnItemClickListener {

    private lateinit var recyclerViewFood: RecyclerView
    private val db = FirebaseDatabase.getInstance().getReference("foods")
    private lateinit var arrayListFood: ArrayList<Food>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        loadFoods()
    }

    private fun init(view: View) {
        recyclerViewFood = view.findViewById(R.id.recyclerViewFood)
        recyclerViewFood.layoutManager = LinearLayoutManager(activity)
        arrayListFood = arrayListOf()
    }

    private fun loadFoods() {
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {

                    arrayListFood.clear()

                    for (snap in snapshot.children) {
                        val currentFood = snap.getValue(Food::class.java)?: return
                        arrayListFood.add(currentFood)
                    }

                    recyclerViewFood.adapter = FoodAdapter(context!!.applicationContext, arrayListFood, this@HomeFragment)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onItemClick(position: Int) {

        val currentItem = arrayListFood[position]
        val title = currentItem.title.toString()
        val description = currentItem.description.toString()
        val imageUrl = currentItem.imageUrl.toString()

        val intent = Intent(activity, FoodInfoActivity::class.java)
        intent.putExtra("title", title)
        intent.putExtra("description", description)
        intent.putExtra("imageUrl", imageUrl)
        startActivity(intent)

    }

}















