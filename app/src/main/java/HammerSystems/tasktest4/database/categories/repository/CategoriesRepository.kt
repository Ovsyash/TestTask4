package HammerSystems.tasktest4.database.categories.repository

import HammerSystems.tasktest4.data.categories.Category
import androidx.lifecycle.LiveData

interface CategoriesRepository {

    val allCategoryDevices: LiveData<List<Category>>
    suspend fun insertCategories(noteModel: Category)
}