package HammerSystems.tasktest4.fragments.dishe

import HammerSystems.tasktest4.api.dishes.DishesApi
import HammerSystems.tasktest4.api.dishes.DishesRetrofit
import HammerSystems.tasktest4.data.dishe.Dishe

class DisheViewModel {
    val dishesApi: DishesApi

    init {
        dishesApi = DishesRetrofit.getDishesRetrofit().create(DishesApi::class.java)
    }

    suspend fun getItemPerson(id: Int): Dishe {
        val dishe = dishesApi.fetchDishe(id)
        return dishe
    }
}