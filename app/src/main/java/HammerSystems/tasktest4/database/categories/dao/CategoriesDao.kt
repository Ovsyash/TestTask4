package HammerSystems.tasktest4.database.categories.dao

import HammerSystems.tasktest4.data.categories.Category
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(categories: Category)

    @Delete
    suspend fun delete(categories: Category)

    @Query("SELECT * from categories_table")
    fun getAllDevices(): LiveData<List<Category>>
}