package HammerSystems.tasktest4.fragments.dishe

import HammerSystems.tasktest4.api.dishes.DishesApi
import HammerSystems.tasktest4.api.dishes.DishesRetrofit
import HammerSystems.tasktest4.data.dishe.Dishe
import HammerSystems.tasktest4.data.dishe.Meal
import androidx.lifecycle.ViewModel

class DisheViewModel : ViewModel() {
    val dishesApi: DishesApi

    init {
        dishesApi = DishesRetrofit.getDishesRetrofit().create(DishesApi::class.java)
    }

    suspend fun getItemDishe(id: Int): Meal {
        val meal = dishesApi.fetchDishe(id)
        return meal
    }
}