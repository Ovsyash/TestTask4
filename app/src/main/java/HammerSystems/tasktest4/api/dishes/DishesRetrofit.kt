package HammerSystems.tasktest4.api.dishes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DishesRetrofit {
    companion object {
        val baseURL = "https://www.themealdb.com/api/"

        fun getDishesRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}