package com.example.todlprojectv1.view.list

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todlprojectv1.R
import com.example.todlprojectv1.database.MainTaskWithSubTask
import com.example.todlprojectv1.view.TodlViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
/***
 * A Fragment represents a reusable portion of your app's UI.
 * A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events.
 * Fragments cannot live on their own--they must be hosted by an activity or another fragment.
 * The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy.
 * */
class TodlListFragment : Fragment() {
    private val todelList = mutableListOf<MainTaskWithSubTask>()
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
        val todlAdapter = TodlAdapter(todelList, todlViewModel,requireActivity().supportFragmentManager)
        /***
         * When your app displays data or uses data in other ways,
         * you usually want to take action when the data changes.
         * This means you have to observe the data so that when it changes,
         * you can react. Depending on how the data is stored,
         * And now you can use LiveData for do that
         * */

        /*** Benefits of using LiveData
         * Ensures that your UI matches your data state
         * No memory leaks
         * No crashes due to stopped activities
         * Data is always up to date
         * Configuration changes handled properly
         * Resources can be shared
         * */
        todelRecycleView.adapter = todlAdapter
        todlViewModel.todlList.observe(viewLifecycleOwner, Observer {
            it?.let { list ->
                todelList.clear()
                todelList.addAll(list)

                todlAdapter.notifyDataSetChanged()
            }
        })
        val sortby: Button = view.findViewById(R.id.sortby)
        sortby.setOnClickListener {
            todelList.sortBy {
                it.task.taskTitle
            }
            todlAdapter.notifyDataSetChanged()

        }


        val fab: FloatingActionButton = view.findViewById(R.id.floating_List)
        val addBottomSheet = TodlAddFragment()
        fab.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.clicksound)
            mediaPlayer.start()// To start the sound on clicking
            addBottomSheet.show(requireActivity().supportFragmentManager,"")
        } }

}

