package HammerSystems.tasktest4.fragments.menu.model

import HammerSystems.tasktest4.api.categories.CategoriesApi
import HammerSystems.tasktest4.api.categories.CategoriesRetrofit
import HammerSystems.tasktest4.api.dishes.DishesApi
import HammerSystems.tasktest4.api.dishes.DishesRetrofit
import HammerSystems.tasktest4.data.banners.Banner
import HammerSystems.tasktest4.data.banners.Banners
import HammerSystems.tasktest4.data.categories.Categories
import HammerSystems.tasktest4.data.categories.Category
import HammerSystems.tasktest4.data.dishes.Dishes
import HammerSystems.tasktest4.data.dishes.Meal
import HammerSystems.tasktest4.database.categories.database.CategoriesDatabase
import HammerSystems.tasktest4.database.categories.repository.CategoriesRealization
import HammerSystems.tasktest4.database.categories.repository.CategoriesRepository
import HammerSystems.tasktest4.database.dishes.database.DishesDatabase
import HammerSystems.tasktest4.database.dishes.repository.DishesRealization
import HammerSystems.tasktest4.database.dishes.repository.DishesRepository
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuViewModel(application: Application) : AndroidViewModel(application) {

    val menuDishesLiveData: MutableLiveData<Dishes> = MutableLiveData()
    lateinit var dishesRepository: DishesRepository
    val menuCategoriesLiveData: MutableLiveData<Categories> = MutableLiveData()
    lateinit var categoriesRepository: CategoriesRepository
    val context = application

    fun internetCheck(c: Context): Boolean {
        val cmg = c.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Android 10+
            cmg.getNetworkCapabilities(cmg.activeNetwork)?.let { networkCapabilities ->
                return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            }
        } else {
            return cmg.activeNetworkInfo?.isConnectedOrConnecting == true
        }
        return false
    }

    fun getDishesListData() {
        viewModelScope.launch {
            val dishesApi: DishesApi =
                DishesRetrofit.getDishesRetrofit().create(DishesApi::class.java)
            val dishesResponse = dishesApi.fetchDishes()
            menuDishesLiveData.postValue(dishesResponse)
        }
    }

    fun getDishesObserver(): MutableLiveData<Dishes> {
        return menuDishesLiveData
    }

    fun initDishesDatabase() {
        val dishes = DishesDatabase.getDishesInstance(context).getDishesDao()
        dishesRepository = DishesRealization(dishes)
    }

    fun getDishesAllNotes(): LiveData<List<Meal>> {
        return dishesRepository.allDishesDevices
    }

    fun dishesInsert(dishes: Meal) =
        viewModelScope.launch(Dispatchers.IO) {
            dishesRepository.insertDishes(dishes)
        }

    fun getCategoriesListData() {
        viewModelScope.launch {
            val categoriesApi: CategoriesApi =
                CategoriesRetrofit.getCategoriesRetrofit().create(CategoriesApi::class.java)
            val categoriesResponse = categoriesApi.fetchCategories()
            menuCategoriesLiveData.postValue(categoriesResponse)
        }
    }

    fun getCategoriesObserver(): MutableLiveData<Categories> {
        return menuCategoriesLiveData
    }

    fun initCategoriesDatabase() {
        val categories = CategoriesDatabase.getCategoriesInstance(context).getCategoriesDao()
        categoriesRepository = CategoriesRealization(categories)
    }

    fun getCategoriesAllNotes(): LiveData<List<Category>> {
        return categoriesRepository.allCategoryDevices
    }

    fun categoriesInsert(categories: Category) =
        viewModelScope.launch(Dispatchers.IO) {
            categoriesRepository.insertCategories(categories)
        }
}

