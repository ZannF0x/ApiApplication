package com.zannardyapps.apiapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zannardyapps.apiapplication.R
import com.zannardyapps.apiapplication.model.Product

class ProductAdapter(
    private var context: Context,
    private var productList: List<Product>,
): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item: Product = productList[position]
        holder.productName.text = item.prName
        holder.productPrice.text = item.prPrice
        Glide.with(context).load(item.prImage)
            .into(holder.productImageView)

    }

    override fun getItemCount(): Int {
        return productList.size
    }


    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val productImageView: ImageView = itemView.findViewById(R.id.imageProduct)
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)

    }
}
