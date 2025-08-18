package com.example.cafe__coffee.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cafe__coffee.Domain.BannerModel
import com.example.cafe__coffee.Repository.MainRepository

class MainViewModel: ViewModel() {
    private  val repository= MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()

    }
}