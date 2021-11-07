package com.example.todlprojectv1.view.SubList

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todlprojectv1.R
import com.example.todlprojectv1.database.TodlModelSubList
import com.example.todlprojectv1.view.TodlViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.contracts.Returns

class SubListAddFragment : BottomSheetDialogFragment() {
    private val todlViewModel: TodlViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sub_list_add, container, false)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tasksubTitle: EditText = view.findViewById(R.id.Tasktitle_edittext_add_sub)
        val prioritysub: RadioGroup = view.findViewById(R.id.radio_group_SubList)
        val addButton: Button = view.findViewById(R.id.Add_button_addlist_sub)
        val cancleButton: Button = view.findViewById(R.id.Cancle_button_addlist_sub)
        val description:String=""
        val mainId: Int = todlViewModel.selectedItemId

        addButton.setOnClickListener {
            val subtask = tasksubTitle.text.toString()
            var subpriorityRadioButton: RadioButton? = view.findViewById(prioritysub.checkedRadioButtonId)
            var subprio = subpriorityRadioButton?.text.toString()
            var des=description
            var mainId = mainId
            if(subpriorityRadioButton == null) {
                Toast.makeText(requireActivity(), "Please pick a priority", Toast.LENGTH_SHORT)
                    .show()
            }

            else{
            todlViewModel.addsubList(TodlModelSubList(subtask,subprio,des,mainId ))
            dismiss()}
        }
            cancleButton.setOnClickListener {
             dismiss()
         }
    }
}