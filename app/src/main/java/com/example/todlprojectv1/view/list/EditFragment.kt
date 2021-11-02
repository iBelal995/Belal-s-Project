package com.example.todlprojectv1.view.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.todlprojectv1.R
import com.example.todlprojectv1.database.TodlModelList
import com.example.todlprojectv1.view.TodlViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment



class EditFragment : BottomSheetDialogFragment() {

    private val todlViewModel: TodlViewModel by activityViewModels()
    private lateinit var todlModlList:TodlModelList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editText:EditText = view.findViewById(R.id.edit_task_title)
        val cancelButton: Button = view.findViewById(R.id.Cancle_button_edittask)
        val editButton: Button = view.findViewById(R.id.edit_text_button)
        todlViewModel.selectedListMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                editText.setText(it.taskTitle)
                todlModlList = it
            }
        })
        cancelButton.setOnClickListener {
            dismiss()
        }
        editButton.setOnClickListener {
            todlModlList.taskTitle = editText.text.toString()
            todlViewModel.updateList(todlModlList)
            dismiss()
        }
    }

}