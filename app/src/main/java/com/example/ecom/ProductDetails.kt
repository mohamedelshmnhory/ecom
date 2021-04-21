package com.example.ecom

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)
        val title = intent.getStringExtra("title")
        var photoUrl = intent.getStringExtra("photo_url")
        product_name.text = title
        Picasso.get().load(photoUrl).into(photo)

        availability.setOnClickListener{
            AlertDialog.Builder(this)
                    .setMessage("It's in stock!")
                    .setPositiveButton("ok"){
                        p0, p1 ->
                    }
                    .create()
                    .show()
        }
    }
}