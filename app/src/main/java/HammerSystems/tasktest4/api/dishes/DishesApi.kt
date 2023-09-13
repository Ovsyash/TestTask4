package HammerSystems.tasktest4.api.dishes

import HammerSystems.tasktest4.data.dish.Dish
import HammerSystems.tasktest4.data.dishes.Dishes
import retrofit2.http.GET
import retrofit2.http.Query

interface DishesApi {
    @GET("json/v1/1/filter.php?c=Beef")
    suspend fun fetchDishes(): Dishes

    @GET("json/v1/1/lookup.php")
    suspend fun fetchDish(@Query("i") idMeal: String): Dish
}
