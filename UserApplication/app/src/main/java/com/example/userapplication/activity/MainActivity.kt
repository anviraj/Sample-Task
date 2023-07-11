package com.example.userapplication.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.R
import com.example.userapplication.adapter.UserApplicationAdapter
import com.example.userapplication.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: UserApplicationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPref = getSharedPreferences("username", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username","")
        findViewById<TextView>(R.id.tvusername).text= username
        Log.d("username",username.toString())

        initRecyclerView()
        initViewModel()
    }



    private fun initRecyclerView() {
       val userapplicationrecyclerview = findViewById<RecyclerView>(R.id.userapplicationrecyclerview)
        userapplicationrecyclerview.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = UserApplicationAdapter(this)
        userapplicationrecyclerview.adapter = recyclerAdapter
    }

    private fun initViewModel() {
        val viewModel:MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
            viewModel.getLiveDataObserver().observe(this, Observer {
                if (it != null) {
                    recyclerAdapter.setuserList(it)
                    recyclerAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this,"error", Toast.LENGTH_SHORT).show()
                }
            })
        viewModel.makeAPICall()
    }
}