package com.example.madlevel2task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ItemVragenlijstBinding
import kotlinx.android.synthetic.main.item_vragenlijst.view.*

class vragenAdapter(private val Vragen: List<Vragenlijst>) : RecyclerView.Adapter<vragenAdapter.ViewHolder>(){


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ItemVragenlijstBinding.bind(itemView)

        fun databind(reminder: Vragenlijst) {
            binding.tvVragenlijst.text = reminder.vragenText
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_vragenlijst, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return Vragen.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(Vragen[position])
    }


}
