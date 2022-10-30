package HammerSystems.tasktest4.database.dishes.dao

import HammerSystems.tasktest4.data.dishes.Meal
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DishesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dishes: Meal)

    @Delete
    suspend fun delete(dishes: Meal)

    @Query("SELECT * from dishes_table")
    fun getAllDevices(): LiveData<List<Meal>>
}