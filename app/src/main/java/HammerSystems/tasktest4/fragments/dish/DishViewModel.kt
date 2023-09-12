package HammerSystems.tasktest4.fragments.dish

import HammerSystems.tasktest4.api.dishes.DishesApi
import HammerSystems.tasktest4.api.dishes.DishesRetrofit
import HammerSystems.tasktest4.data.dish.Dish
import HammerSystems.tasktest4.data.dish.Meal
import android.util.Log
import androidx.lifecycle.ViewModel

class DishViewModel : ViewModel() {
    private val dishesApi: DishesApi = DishesRetrofit.getDishesRetrofit().create(DishesApi::class.java)

    suspend fun getItemDish(id: String): Meal {
        Log.d("idMeals", id)
        Log.d("idMeals2", dishesApi.fetchDish(id).toString())
        return dishesApi.fetchDish(id)
    }
}