package com.example.todlprojectv1.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todlprojectv1.database.TodlModelList
import com.example.todlprojectv1.repository.TodlRepository
import androidx.lifecycle.viewModelScope
import com.example.todlprojectv1.database.MainTaskWithSubTask
import com.example.todlprojectv1.database.TodlModelSubList
import kotlinx.coroutines.launch

class TodlViewModel:ViewModel() {
    // Getting instance from inventory repository with companion object function
    private val todlRepository = TodlRepository.get()

    var todlList = todlRepository.getList()
    fun todlsubList (taskId:Int)= todlRepository.getsubList(taskId)
    var selectedItemId = 0


    var selectedListMutableLiveData = MutableLiveData<TodlModelList>()//نقل الداتا من تو دو لست الى السب لست
    var selectedListSubMutableLiveData = MutableLiveData<TodlModelSubList>()//من السب لست الى الديتيلز


    fun addList(todlModelList:TodlModelList){

            viewModelScope.launch {
                todlRepository.addList(todlModelList)
            }

}
        fun updateList(todlModelList: TodlModelList) {
            viewModelScope.launch {
                todlRepository.updateList(todlModelList)
            }
        }

        fun deleteList(todlModelList: TodlModelList){
            viewModelScope.launch {
                todlRepository.deleteList(todlModelList)
            }
        }
// sub task opreations
    fun addsubList(todlModelSubList:TodlModelSubList){

        viewModelScope.launch {
            todlRepository.addsubList(todlModelSubList)
        }

    }
    fun updatesubList(todlModelSubList: TodlModelSubList) {
        viewModelScope.launch {
            todlRepository.updatesubList(todlModelSubList)
        }
    }

    fun deletesubList(todlModelSubList: TodlModelSubList){
        viewModelScope.launch {
            todlRepository.deletesubList(todlModelSubList)
        }
    }

}
