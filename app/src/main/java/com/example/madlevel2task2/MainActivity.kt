package com.example.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val Vragen = arrayListOf<Vragenlijst>()
    private val vragenAdapter = com.example.madlevel2task2.vragenAdapter(Vragen)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.rvVragenlijst.layoutManager= LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        binding.rvVragenlijst.adapter = vragenAdapter
        binding.rvVragenlijst.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

        for (i in Vragenlijst.vragen.indices) {
            Vragen.add(Vragenlijst(Vragenlijst.vragen[i]))
        }
       vragenAdapter.notifyDataSetChanged()

        createItemTouchHelper().attachToRecyclerView(rvVragenlijst)
    }

    private fun createItemTouchHelper(): ItemTouchHelper {
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                Vragen.removeAt(position)
               vragenAdapter.notifyDataSetChanged()
            }
        }
        return ItemTouchHelper(callback)

    }

}


