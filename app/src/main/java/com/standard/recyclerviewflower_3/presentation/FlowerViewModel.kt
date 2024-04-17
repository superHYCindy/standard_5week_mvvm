package com.standard.recyclerviewflower_3.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.standard.recyclerviewflower_3.data.DataSource
import com.standard.recyclerviewflower_3.data.Flower
import com.standard.recyclerviewflower_3.data.flowerList

class FlowerViewModel(val dataSource: DataSource) : ViewModel() {
    val flowersLiveData = dataSource.getFlowerList()

    fun getFlowerForId(id : Long) : Flower {
        return flowersLiveData.get(id.toInt())
    }
}

//viewModel 생성
class FlowerViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlowerViewModel::class.java)) {
            return FlowerViewModel(dataSource = DataSource.getDataSource()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}

