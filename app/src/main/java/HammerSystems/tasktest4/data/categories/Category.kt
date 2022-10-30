package HammerSystems.tasktest4.data.categories

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_table")
data class Category(
    @PrimaryKey(autoGenerate = false)
    var idCategory: String,
    var strCategory: String,
)