package HammerSystems.tasktest4.api.dishes

import HammerSystems.tasktest4.data.dishes.Dishes
import retrofit2.http.GET

interface DishesApi {

    @GET("json/v1/1/filter.php?c=Beef")
    suspend fun fetchDishes(): Dishes
}