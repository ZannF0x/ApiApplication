package com.zannardyapps.apiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zannardyapps.apiapplication.adapter.ProductAdapter
import com.zannardyapps.apiapplication.api.MyRetrofit
import com.zannardyapps.apiapplication.databinding.ActivityMainBinding
import com.zannardyapps.apiapplication.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var recyclerViewProducts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewProducts = binding.layoutRecyclerProduct
        recyclerViewProducts.layoutManager = LinearLayoutManager(this)

        getData()
    }

    private fun getData(){
        val call: Call<List<Product>> = MyRetrofit
            .instance?.productApi()?.getProductApi() as Call<List<Product>>

        call.enqueue(object : Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                val adapter = ProductAdapter(this@MainActivity, response.body() as List<Product>)

                recyclerViewProducts.adapter = adapter
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ERRO ao fazer Requisição!", Toast.LENGTH_LONG).show()
            }

        })
    }
}