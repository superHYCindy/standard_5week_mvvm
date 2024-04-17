package com.standard.recyclerviewflower_3.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.standard.recyclerviewflower_3.extension.extraNotNull

class FlowerDetailActivity : AppCompatActivity(){
    companion object {
        const val EXTRA_FLOWER : String = "extra_flower"
    }

    private val flowerViewModel by viewModels<FlowerViewModel> {
        FlowerViewModelFactory()
    }

    private val flowerId by extraNotNull<Long>(EXTRA_FLOWER)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        flowerViewModel.getFlowerForId(flowerId)
        //넘어온 값 확인
        Log.d("debug100",flowerViewModel.getFlowerForId(flowerId).toString())

    }
}