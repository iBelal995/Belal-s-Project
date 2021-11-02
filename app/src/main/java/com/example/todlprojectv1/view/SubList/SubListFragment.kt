package com.example.todlprojectv1.view.SubList

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.todlprojectv1.R
import com.example.todlprojectv1.database.MainTaskWithSubTask
import com.example.todlprojectv1.database.TodlModelList
import com.example.todlprojectv1.database.TodlModelSubList
import com.example.todlprojectv1.view.TodlViewModel
import com.example.todlprojectv1.view.list.EditFragment
import com.example.todlprojectv1.view.list.TodlAdapter
import com.example.todlprojectv1.view.list.TodlListFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SubListFragment : Fragment() {
    private val todlsubList = mutableListOf<TodlModelSubList> ()
    private lateinit var todlModlList:TodlModelList
        private val todlViewModel: TodlViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sub_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?,) {
        super.onViewCreated(view, savedInstanceState)

        val todelsubRecycleView: RecyclerView = view.findViewById(R.id.recycle_View_Sub)
        val todlsubAdapter = TodlSubAdapter(todlsubList, todlViewModel)
        val textView:TextView = view.findViewById(R.id.textviewsub)

//         textView.text= todlViewModel.selectedListMutableLiveData.observe(viewLifecycleOwner,
//             Observer {it?.let { textView.setText(todlModlList.taskTitle)
//                 todlViewModel.selectedItemId = todlModlList.taskId
//                 todlModlList = it
//
//             }}).toString()


        todelsubRecycleView.adapter = todlsubAdapter
        todlViewModel.todlsubList(todlViewModel.selectedItemId).observe(viewLifecycleOwner, Observer {
            it?.let { list ->
                todlsubList.clear()
                todlsubList.addAll(list)
                todlsubAdapter.notifyDataSetChanged()
            } })
        val fab: FloatingActionButton = view.findViewById(R.id.floating_subList)
        val addBottomSheet = SubListAddFragment()
        fab.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.clicksound)
            mediaPlayer.start()// To start the sound on clicking
            addBottomSheet.show(requireActivity().supportFragmentManager,"")
        } }
    }
