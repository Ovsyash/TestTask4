package HammerSystems.tasktest4.database.categories.database

import HammerSystems.tasktest4.data.categories.Category
import HammerSystems.tasktest4.database.categories.dao.CategoriesDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Category::class], version = 1)
abstract class CategoriesDatabase: RoomDatabase() {
    abstract fun getCategoriesDao(): CategoriesDao

    companion object{
        private var categoriesDatabase: CategoriesDatabase ?= null
        @Synchronized
        fun getCategoriesInstance(context: Context): CategoriesDatabase{
            return if (categoriesDatabase == null){
                categoriesDatabase = Room.databaseBuilder(context, CategoriesDatabase::class.java, "dishesDatabase").build()
                categoriesDatabase as CategoriesDatabase
            } else {
                categoriesDatabase as CategoriesDatabase
            }
        }
    }
}