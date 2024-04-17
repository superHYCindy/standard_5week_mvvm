package com.standard.recyclerviewflower_3.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.standard.recyclerviewflower_3.R
import com.standard.recyclerviewflower_3.data.Flower
import com.standard.recyclerviewflower_3.databinding.FlowerItemBinding

class FlowersAdapter(private val onClick : (Flower) -> Unit) : RecyclerView.Adapter<FlowersAdapter.FlowerViewHolder>() {

    var flowerList = listOf<Flower>()

    class FlowerViewHolder(private var binding : FlowerItemBinding, val onClick : (Flower) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        private var currentFlower : Flower ?= null
        init {
            itemView.setOnClickListener {
                currentFlower?.let {
                    onClick(it)
                }
            }
        }
        fun bind(flower : Flower) {
            currentFlower = flower

            binding.flowerImage.setImageResource(flower.image)
            binding.flowerText.text = flower.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flower_item,parent, false)
        return FlowerViewHolder(FlowerItemBinding.bind(view),onClick)
    }

    override fun getItemCount(): Int {
        return flowerList.size
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
       holder.bind(flowerList[position])
    }
}