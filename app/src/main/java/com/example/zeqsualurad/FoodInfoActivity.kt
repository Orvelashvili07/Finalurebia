package com.example.zeqsualurad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class FoodInfoActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var titleTW: TextView
    private lateinit var descriptionTW: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_info)

        titleTW = findViewById(R.id.title)
        descriptionTW = findViewById(R.id.description)
        imageView = findViewById(R.id.imageView)


        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val imageUrl = intent.getStringExtra("imageUrl")

        titleTW.text = title
        descriptionTW.text = description

        Glide.with(this)
            .load(imageUrl)
            .into(imageView)
    }

}