 package com.example.ecom

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecom.model.Product
import kotlinx.android.synthetic.main.content_main.*


 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val products = arrayListOf<Product>()
        for (i in 0..100){
            products.add(Product("Organic Apple","https://pbs.twimg.com/profile_images/883859744498176000/pjEHfbdn_400x400.jpg ",1.5))
        }

        recycler.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2)
            setHasFixedSize(true)
            adapter = ProductsAdapter(products)
        }
    }

}