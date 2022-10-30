package HammerSystems.tasktest4.database.dishes.database

import HammerSystems.tasktest4.data.dishes.Meal
import HammerSystems.tasktest4.database.dishes.dao.DishesDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Meal::class], version = 1)
abstract class DishesDatabase: RoomDatabase() {
    abstract fun getDishesDao(): DishesDao

    companion object{
        private var dishesDatabase: DishesDatabase ?= null
        @Synchronized
        fun getDishesInstance(context: Context): DishesDatabase{
            return if (dishesDatabase == null){
                dishesDatabase = Room.databaseBuilder(context, DishesDatabase::class.java, "dishesDatabase").build()
                dishesDatabase as DishesDatabase
            } else {
                dishesDatabase as DishesDatabase
            }
        }
    }
}