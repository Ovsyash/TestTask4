package HammerSystems.tasktest4.data.dishes

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "dishes_table")
data class Meal(
    @PrimaryKey(autoGenerate = false)
    var idMeal: String,
    var strMeal: String,
    var strMealThumb: String,
    var priceDishes: String,
)