package com.example.ecom

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecom.model.Product
import com.squareup.picasso.Picasso

class ProductsAdapter(private val products:List<Product>) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        Picasso.get().load(product.photo_url).into(holder.image)
        holder.title.text = product.name
        holder.price.text = product.price.toString()
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
         val holder = ViewHolder(view)
         view.setOnClickListener(){
             val intent = Intent(parent.context,ProductDetails::class.java)
             intent.putExtra("title",products[holder.adapterPosition].name)
             intent.putExtra("photo_url",products[holder.adapterPosition].photo_url)
             parent.context.startActivity(intent)
         }
         return holder
    }
    override fun getItemCount() = products.size

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)
    }

}