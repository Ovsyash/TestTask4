package HammerSystems.tasktest4.api.dishes

import HammerSystems.tasktest4.data.dishe.Dishe
import HammerSystems.tasktest4.data.dishe.Meal
import HammerSystems.tasktest4.data.dishes.Dishes
import retrofit2.http.GET
import retrofit2.http.Path

interface DishesApi {

    @GET("json/v1/1/filter.php?c=Beef")
    suspend fun fetchDishes(): Dishes

    @GET("api/json/v1/1/lookup.php?i={id}")
    suspend fun fetchDishe(@Path("id") query: Int): Meal
}