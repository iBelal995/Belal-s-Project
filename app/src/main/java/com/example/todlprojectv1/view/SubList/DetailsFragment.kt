package com.example.todlprojectv1.view.SubList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.todlprojectv1.R
import com.example.todlprojectv1.database.TodlModelSubList
import com.example.todlprojectv1.view.TodlViewModel


class DetailsFragment : Fragment() {
    private val todlsubList = mutableListOf<TodlModelSubList>()
    private val todlViewModel: TodlViewModel by activityViewModels()
    private lateinit var selectedItem: TodlModelSubList
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val details:EditText = view.findViewById(R.id.edittext)

        val description: EditText = view.findViewById(R.id.editTextTextMultiLine)
        todlViewModel.selectedListSubMutableLiveData.observe(viewLifecycleOwner, {
            it?.let { item ->
                description.setText(item.description)
                selectedItem = item


//                todlViewModel.addsubList(selectedItem)
//
//                todlViewModel.updatesubList(selectedItem)
            }
        }
        )
    }
     fun afterTextChanged(des: Any? = view?.findViewById(R.id.editTextTextMultiLine)): Unit{
     }
    fun beforeTextChanged(
        s: CharSequence,
        start: Int,
        count: Int,
        after: Int
    ): Unit{}
     fun onTextChanged(
        s: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ): Unit{}
}