package HammerSystems.tasktest4.api.categories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoriesRetrofit {
    companion object {
        val baseURL = "https://www.themealdb.com/api/"

        fun getCategoriesRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}