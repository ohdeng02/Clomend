package com.example.clomend.coordi_book

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoordiBookViewModel: ViewModel() {
    val data = MutableLiveData<CoordibookData>()

    fun sendarray(coordibookData: CoordibookData){
        data.value = coordibookData
    }
}