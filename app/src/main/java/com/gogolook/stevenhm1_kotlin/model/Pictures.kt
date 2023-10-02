package com.gogolook.stevenhm1_kotlin.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gogolook.stevenhm1_kotlin.data.Datasource
import com.gogolook.stevenhm1_kotlin.data.Picture
import com.gogolook.stevenhm1_kotlin.data.PictureRepository

class MainActivityViewModel:ViewModel(){

    //
    val list:MutableLiveData<List<Picture>> =   MutableLiveData<List<Picture>>()//mutableListOf<Picture>()
    fun loadNextPage(){

    }
    fun newSearch(){

        val myDataset = Datasource().loadPictures("book store1", 1) //List<Picture>
        list.postValue(myDataset)
        val picutreRepository=PictureRepository()
        list.postValue(picutreRepository.queryImages("tmp",1))
    }


}


data class Pictures (val stringResourceID:Int) {



}