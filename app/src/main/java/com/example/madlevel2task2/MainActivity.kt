package com.example.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val Vragen = arrayListOf<Vragenlijst>()
    private val vragenAdapter = com.example.madlevel2task2.vragenAdapter(Vragen)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initViews() {
        binding.rvVragenlijst.layoutManager= LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        binding.rvVragenlijst.adapter = vragenAdapter
        binding.rvVragenlijst.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

    }

}