package HammerSystems.tasktest4.database.dishes.repository

import HammerSystems.tasktest4.data.dishes.Meal
import HammerSystems.tasktest4.database.dishes.dao.DishesDao
import androidx.lifecycle.LiveData

class DishesRealization(private val dishesDao: DishesDao): DishesRepository {

    override val allDishesDevices: LiveData<List<Meal>>
        get() = dishesDao.getAllDevices()

    override suspend fun insertDishes(noteModel: Meal) {
        dishesDao.insert(noteModel)
    }
}