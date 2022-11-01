package com.example.clomend.community

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CommunityViewModel: ViewModel() {
    val data = MutableLiveData<CommunityData>()

    fun sendarray(communityData: CommunityData){
        data.value = communityData
    }
}