package com.example.todlprojectv1.view.SubList

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
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
        val update: Button = view.findViewById(R.id.update_button)
        val cancel:Button = view.findViewById(R.id.Cancel_button)
        todlViewModel.selectedListSubMutableLiveData.observe(viewLifecycleOwner, {
            it?.let { item ->
                description.setText(item.description)

                selectedItem = item

            }
        }
        )

        update.setOnClickListener {
            selectedItem.description = description.text.toString()
            todlViewModel.updatesubList(selectedItem)
            findNavController().popBackStack()
        }
        cancel.setOnClickListener {
            val inputManager: InputMethodManager =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                requireActivity().currentFocus!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
            update.visibility = View.INVISIBLE
            cancel.visibility = View.INVISIBLE
            description.clearFocus()
        }

        description.setOnFocusChangeListener { v, hasFocus ->

            if (hasFocus) {
                update.visibility = View.VISIBLE
                cancel.visibility = View.VISIBLE
            }else
            {
                update.visibility = View.INVISIBLE
                cancel.visibility = View.INVISIBLE
            }
        }

        }
    }

