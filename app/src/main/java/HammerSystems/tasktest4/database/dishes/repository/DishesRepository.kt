package HammerSystems.tasktest4.database.dishes.repository

import HammerSystems.tasktest4.data.dishes.Meal
import androidx.lifecycle.LiveData

interface DishesRepository {

    val allDishesDevices: LiveData<List<Meal>>
    suspend fun insertDishes(noteModel: Meal)
}