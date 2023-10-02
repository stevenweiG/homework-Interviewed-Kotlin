package com.gogolook.stevenhm1_kotlin.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gogolook.stevenhm1_kotlin.data.Picture

class ItemAdapter (private val context:Context, var dataset:List<Picture>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view:View):RecyclerView.ViewHolder(view){

        val id:TextView = view.findViewById<TextView>(com.gogolook.stevenhm1_kotlin.R.id.txtID)
        val views:TextView = view.findViewById<TextView>(com.gogolook.stevenhm1_kotlin.R.id.txtViews)
        val downloads:TextView = view.findViewById<TextView>(com.gogolook.stevenhm1_kotlin.R.id.txtDownloads)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout=LayoutInflater.from(parent.context).inflate(com.gogolook.stevenhm1_kotlin.R.layout.list_item,parent,false)

        return ItemViewHolder(adapterLayout)



    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item=dataset[position]
        holder.id.text="ID: ${item.id}"
        holder.views.text="Views: ${item.views}"
        holder.downloads.text="Downloads: ${item.downloads}"


    }

}