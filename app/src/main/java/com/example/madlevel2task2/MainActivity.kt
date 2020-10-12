package com.example.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val Vragen = arrayListOf<Vragenlijst>()
    private val vragenAdapter = vragenAdapter(Vragen)
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

        Vragen.addAll(Vragenlijst.vragen)
       vragenAdapter.notifyDataSetChanged()

        createItemTouchHelper().attachToRecyclerView(rvVragenlijst)
    }

    private fun createItemTouchHelper(): ItemTouchHelper {
        val Swipe = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        {

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
                var Vraag = Vragen[position]
                if ((Vraag.vraagCorrect && direction == ItemTouchHelper.RIGHT)||(!Vraag.vraagCorrect && direction == ItemTouchHelper.LEFT)){
                    Vragen.removeAt(position)
                    vragenAdapter.notifyDataSetChanged()
                }else {
                    Snackbar.make(viewHolder.itemView,"This question will not be removed", Snackbar.LENGTH_LONG).show()
                    vragenAdapter.notifyItemChanged(position)
                }



            }
        }
        return ItemTouchHelper(Swipe)


    }


}


