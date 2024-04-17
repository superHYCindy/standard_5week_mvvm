package com.standard.recyclerviewflower_3.data

import com.standard.recyclerviewflower_3.R


fun flowerList(): List<Flower> {
    return listOf(
        Flower(
            id = 0,
            name = "장미",
            image = R.drawable.dahlia,
            "This is Rose"
        ),
        Flower(
            id = 1,
            name = "dahila",
            image = R.drawable.dahlia,
            "This is dahila"
        ),
        Flower(
            id = 2,
            name = "장미",
            image = R.drawable.dahlia,
            "This is daisy"
        )
    )
}
