package com.example.messakem_prat.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.messakem_prat.R
import com.example.messakem_prat.databinding.ItemSquadBinding
import com.example.messakem_prat.models.Squad

class MySquadRecyclerViewAdapter(
    private val values: ArrayList<Squad> = arrayListOf()
) : RecyclerView.Adapter<MySquadRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemSquadBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_squad,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item)
    }

    fun setData(list: ArrayList<Squad>) {
        values.clear()
        values.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: ItemSquadBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(squad: Squad) {
            binding.squad = squad
            binding.executePendingBindings()
        }
    }

}