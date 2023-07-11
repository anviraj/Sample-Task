package com.example.userapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userapplication.data.UserModel
import com.example.userapplication.retrofit.RetroInstance
import com.example.userapplication.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var liveDataList: MutableLiveData<UserModel>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver() : MutableLiveData<UserModel>{
        return liveDataList
    }

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getUserApplication()
        call.enqueue(object : Callback<UserModel> {

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<UserModel>,
                response: Response<UserModel>
            ) {
                liveDataList.postValue(response.body())
            }
        })

    }


}