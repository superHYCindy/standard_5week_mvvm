package com.standard.recyclerviewflower_3.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.standard.recyclerviewflower_3.data.DataSource
import com.standard.recyclerviewflower_3.data.Flower
import com.standard.recyclerviewflower_3.data.flowerList
import com.standard.recyclerviewflower_3.databinding.ActivityFlowersListBinding
import com.standard.recyclerviewflower_3.extension.launchActivity

class FlowerListActivity : AppCompatActivity() {
    private val binding: ActivityFlowersListBinding by lazy {
        ActivityFlowersListBinding.inflate(layoutInflater)
    }
    private val flowerViewModel by viewModels<FlowerViewModel> {
        FlowerViewModelFactory()
    }


    private val flowersAdapter : FlowersAdapter by lazy {
        FlowersAdapter{
            //onClick 코드 블록 실행
            //DetailActivity.kt
            //intent start
            adapterOnClick(it)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //flowersAdapter.flowerList = DataSource.getDataSource().getFlowerList()
        //viewModel값 가져오기
        flowersAdapter.flowerList = flowerViewModel.flowersLiveData


        with(binding.recyclerView) {
            adapter = flowersAdapter
        }
    }


    fun adapterOnClick(flower:Flower) {
        launchActivity<FlowerDetailActivity>(
            FlowerDetailActivity.EXTRA_FLOWER to flower.id
        )
    }
}