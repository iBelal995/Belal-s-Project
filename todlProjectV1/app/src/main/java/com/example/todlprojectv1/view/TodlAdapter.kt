package com.example.todlprojectv1.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todlprojectv1.R
import com.example.todlprojectv1.database.MainTaskWithSubTask
import com.example.todlprojectv1.database.TodlModelList


class TodlAdapter(val listTask: List<MainTaskWithSubTask>, val todelViewModel: TodlViewModel): RecyclerView.Adapter<TodlAdapter.TodelViewHolder>() {
    class TodelViewHolder(view:View):RecyclerView.ViewHolder(view){
        val taskTitlea:TextView = view.findViewById(R.id.SubList_TextView)
        val taskPrioritya:TextView= view.findViewById(R.id.subList__prio_TextView)
        val edit: Button = view.findViewById(R.id.editbutton)
        val delete: Button = view.findViewById(R.id.subdelete_button)

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
        val list = listTask[position].task
        holder.taskTitlea.text = list.taskTitle.toUpperCase()
        holder.taskPrioritya.text = list.priority
        when(list.priority){
            "High"-> holder.taskPrioritya.setBackgroundColor(Color.parseColor("#FD2E2E"))
            "Medium"-> holder.taskPrioritya.setBackgroundColor(Color.parseColor("#FFB74D"))
            "Low" -> holder.taskPrioritya.setBackgroundColor(Color.parseColor("#6DFF4D"))
        }

        holder.edit.setOnClickListener{it ->
            todelViewModel.selectedListMutableLiveData.postValue(list)
            it.findNavController().navigate(R.id.action_todlListFragment2_to_subListFragment)
        }
        holder.delete.setOnClickListener {
            todelViewModel.deleteList(list)
        }
    }

    override fun getItemCount(): Int {
        return listTask.size
    }
}
