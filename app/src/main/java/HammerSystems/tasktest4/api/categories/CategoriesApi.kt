package HammerSystems.tasktest4.api.categories

import HammerSystems.tasktest4.data.categories.Categories
import retrofit2.http.GET

interface CategoriesApi {

    @GET("json/v1/1/categories.php")
    suspend fun fetchCategories(): Categories
}