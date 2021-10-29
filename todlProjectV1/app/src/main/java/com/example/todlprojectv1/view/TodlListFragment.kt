package com.example.todlprojectv1.view

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todlprojectv1.R
import com.example.todlprojectv1.database.TodlModelList
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodlListFragment : Fragment() {
    private val todelList = mutableListOf<TodlModelList>()
    private val todlViewModel: TodlViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todl_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todelRecycleView: RecyclerView = view.findViewById(R.id.recycle_View)
        val todlAdapter = TodlAdapter(todelList, todlViewModel)

        todelRecycleView.adapter = todlAdapter
        todlViewModel.todlList.observe(viewLifecycleOwner, Observer {
            it?.let { list ->
                todelList.clear()
                todelList.addAll(list)
                todlAdapter.notifyDataSetChanged() } })
        val fab: FloatingActionButton = view.findViewById(R.id.floating)
        fab.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.clicksound)
            mediaPlayer.start()// To start the sound on clicking

            findNavController().navigate(R.id.action_todlListFragment2_to_todlAddFragment)
        } }

}

