package HammerSystems.tasktest4.fragments.dish

import HammerSystems.tasktest4.api.dishes.DishesApi
import HammerSystems.tasktest4.api.dishes.DishesRetrofit
import HammerSystems.tasktest4.data.dish.Dish
import HammerSystems.tasktest4.data.dish.Meal
import androidx.lifecycle.ViewModel
import java.lang.Exception

class DishViewModel : ViewModel() {
    private val dishesApi: DishesApi =
        DishesRetrofit.getDishesRetrofit().create(DishesApi::class.java)

    suspend fun getItemDish(idMeal: String): Meal? {
        return try {
            dishesApi.fetchDish(idMeal).meals.getOrNull(0)
        } catch (e: Exception) {
            "dishesApi.fetchDish"
            null
        }
    }
}