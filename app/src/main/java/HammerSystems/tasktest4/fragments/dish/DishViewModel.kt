package HammerSystems.tasktest4.fragments.dish

import HammerSystems.tasktest4.api.dishes.DishesApi
import HammerSystems.tasktest4.api.dishes.DishesRetrofit
import HammerSystems.tasktest4.data.dishe.MealDish
import androidx.lifecycle.ViewModel

class DishViewModel : ViewModel() {
    val dishesApi: DishesApi

    init {
        dishesApi = DishesRetrofit.getDishesRetrofit().create(DishesApi::class.java)
    }

    suspend fun getItemDishe(id: String): MealDish {
        val meal = dishesApi.fetchDishe(id)
        return meal
    }
}