package com.example.todlprojectv1.view.list

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todlprojectv1.R
import com.example.todlprojectv1.database.MainTaskWithSubTask
import com.example.todlprojectv1.view.TodlViewModel
import java.text.SimpleDateFormat
import java.util.*


class TodlAdapter(val listTask: List<MainTaskWithSubTask>, val todlViewModel: TodlViewModel): RecyclerView.Adapter<TodlAdapter.TodelViewHolder>() {
    class TodelViewHolder(view:View):RecyclerView.ViewHolder(view){
        val taskTitlea:TextView = view.findViewById(R.id.List_TextView)
        val taskPrioritya:TextView= view.findViewById(R.id.List__prio_TextView)
        val delete: Button = view.findViewById(R.id.delete_button)
        val creationdate:TextView = view.findViewById(R.id.creationdate)
        val duedateshow:TextView =view.findViewById(R.id.textView4)
        val Completed:CheckBox = view.findViewById(R.id.checkBox)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodelViewHolder {
        return TodelViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout2,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodelViewHolder, position: Int) {


        val list = listTask[position].task
        val creationDate = list.creationDate
        holder.duedateshow.text = list.dueDate
        holder.creationdate.text = SimpleDateFormat("yyyy/MM/d").format(creationDate)
        holder.taskTitlea.text = list.taskTitle.toUpperCase()
        holder.taskPrioritya.text = list.priority
        holder.Completed.isChecked = list.completed



        val currentDate = Date()
        val formata = SimpleDateFormat("yyyy/MM/dd")
        val duedate = formata.parse(list.dueDate)
        if (currentDate>duedate && !list.completed){
            holder.taskTitlea.setBackgroundColor(Color.parseColor("#60FF0000"))// // احمر
        }
        else if (list.completed){
            holder.taskTitlea.setBackgroundColor(Color.parseColor("#9EFF00"))//اخضر
        }
        else{
            holder.taskTitlea.setBackgroundColor(Color.parseColor("#6800B8FF"))//ازرق
        }
        holder.Completed.setOnClickListener(){
            if(holder.Completed.isChecked){
                holder.taskTitlea.setBackgroundColor(Color.parseColor("#9EFF00"))//اخضر
            }
            else{
                holder.taskTitlea.setBackgroundColor(Color.parseColor("#6800B8FF"))//ازرق
            }
            list.completed = holder.Completed.isChecked
            todlViewModel.updateList(list)
        }

        when(list.priority){
            "High"-> holder.taskPrioritya.setTextColor(Color.parseColor("#9FFD2E2E"))
            "Med"-> holder.taskPrioritya.setTextColor(Color.parseColor("#A1FFB74D"))
            "Low" -> holder.taskPrioritya.setTextColor(Color.parseColor("#9F6DFF4D"))
        }



        holder.itemView.setOnClickListener{it ->
            todlViewModel.selectedItemId = list.taskId
         //   todlViewModel.selectedListMutableLiveData.postValue(listTask[position].subTask)//ارسال السب تاسك الخاصة بالمين الى فراقمنت الساب التاسك
            it.findNavController().navigate(R.id.action_todlListFragment2_to_subListFragment)

        }
        holder.delete.setOnClickListener {
            val alertDialog = AlertDialog
                .Builder(holder.itemView.context)
                .setTitle("Delete Task")
                .setMessage("Are you sure you want to delete the task?")

            alertDialog.setPositiveButton("Yes") { _, _ ->
                todlViewModel.deleteList(list)
            }

            alertDialog.setNegativeButton("No") { dialog, _ ->
                dialog.cancel()
            }

            alertDialog.create().show()

        }

    }

    override fun getItemCount(): Int {
        return listTask.size
    }
}
