package com.example.todlprojectv1.view

import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import com.example.todlprojectv1.R
import com.example.todlprojectv1.database.TodlModelList

class TodlAdapter(val listTask: List<TodlModelList>,val todelViewModel: TodlViewModel): RecyclerView.Adapter<TodlAdapter.TodelViewHolder>() {
    class TodelViewHolder(view:View):RecyclerView.ViewHolder(view){
        val taskTitlea:TextView = view.findViewById(R.id.List_TextView)
        val taskPrioritya:TextView= view.findViewById(R.id.List__prio_TextView)
        val edit: Button = view.findViewById(R.id.editbutton)
        val delete: Button = view.findViewById(R.id.delete_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodlAdapter.TodelViewHolder {
        return TodelViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout2,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodlAdapter.TodelViewHolder, position: Int) {
        val list = listTask[position]
        holder.taskTitlea.text = list.taskTitle
        holder.taskPrioritya.text = list.priority
        holder.edit.setOnClickListener{ it
            it.findNavController().navigate(R.id.action_todlListFragment2_to_detailsFragment)
        }
    }

    override fun getItemCount(): Int {
        return listTask.size
    }
}