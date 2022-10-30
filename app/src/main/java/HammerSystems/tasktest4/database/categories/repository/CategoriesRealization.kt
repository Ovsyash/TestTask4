package HammerSystems.tasktest4.database.categories.repository


import HammerSystems.tasktest4.data.categories.Category
import HammerSystems.tasktest4.database.categories.dao.CategoriesDao
import androidx.lifecycle.LiveData

class CategoriesRealization(private val categoriesDao: CategoriesDao): CategoriesRepository {

    override val allCategoryDevices: LiveData<List<Category>>
        get() = categoriesDao.getAllDevices()

    override suspend fun insertCategories(noteModel: Category) {
        categoriesDao.insert(noteModel)
    }
}