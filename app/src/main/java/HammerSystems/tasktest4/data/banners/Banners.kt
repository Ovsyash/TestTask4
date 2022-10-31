package HammerSystems.tasktest4.data.banners

import HammerSystems.tasktest4.R

object Banners {

    fun getBannerList(): List<Banner> {
        return listOf(
            Banner(
                R.drawable.banner_one,
            ),

            Banner(
                R.drawable.banner_two,
            ),

            Banner(
                R.drawable.banner_three,
            )
        )
    }
}