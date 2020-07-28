package com.example.recyclerviewactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class Adapter(): RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var data = arrayListOf<String>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            itemView.tvOne.text = item

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun update(data: ArrayList<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun delete(pos: Int) {
        if (pos > -1 && data.size > pos) {
            data.removeAt(pos)
            notifyItemRemoved(pos)
            notifyItemRangeChanged(pos, data.size)
        }
    }

    fun add(item: String) {
        data.add(0, item)
        notifyItemInserted(1)
    }
}
