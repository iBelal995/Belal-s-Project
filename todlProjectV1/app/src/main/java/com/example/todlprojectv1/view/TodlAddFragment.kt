package com.example.todlprojectv1.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todlprojectv1.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class TodlAddFragment : BottomSheetDialogFragment() {
    private val todlViewModel: TodlViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todl_add, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val taskTitle: EditText = view.findViewById(R.id.Tasktitle_edittext_add)
        val subTaskTitle: EditText = view.findViewById(R.id.Subtitle_edittext_add)
        val priority: RadioGroup = view.findViewById(R.id.radio_group)
        val high :RadioButton = view.findViewById(R.id.radioButton_high)
        val medium :RadioButton = view.findViewById(R.id.radioButton_medium)
        val low :RadioButton = view.findViewById(R.id.radioButton_low)
        val addButton: Button = view.findViewById(R.id.Add_button_addlist)
        val cancleButton: Button = view.findViewById(R.id.Cancle_button_addlist)
        addButton.setOnClickListener {
            val task = taskTitle.text
            val subtask = subTaskTitle.text
            val prio = priority.checkedRadioButtonId

                todlViewModel.addList(task.toString(), subtask.toString(), prio)


            findNavController().popBackStack()

        }
            cancleButton.setOnClickListener {
                findNavController().popBackStack()

            }

    }
}

