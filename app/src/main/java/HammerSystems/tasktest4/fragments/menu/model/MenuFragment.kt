package HammerSystems.tasktest4.fragments.menu.model

import HammerSystems.tasktest4.R
import HammerSystems.tasktest4.ScannerActivity
import HammerSystems.tasktest4.data.banners.Banners
import HammerSystems.tasktest4.data.categories.Category
import HammerSystems.tasktest4.data.dishe.MealDish
import HammerSystems.tasktest4.data.dishes.Meal
import HammerSystems.tasktest4.databinding.FragmentMenuBinding
import HammerSystems.tasktest4.fragments.dish.DishFragment
import HammerSystems.tasktest4.fragments.menu.adapter.BannersAdapter
import HammerSystems.tasktest4.fragments.menu.adapter.CategoriesAdapter
import HammerSystems.tasktest4.fragments.menu.adapter.DishesAdapter
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_menu.qr_code
import kotlin.random.Random

class MenuFragment : Fragment() {

    lateinit var binding: FragmentMenuBinding
    lateinit var dishesRecyclerView: RecyclerView
    lateinit var dishesadapter: DishesAdapter
    lateinit var categoriesRecyclerView: RecyclerView
    lateinit var categoriesadapter: CategoriesAdapter
    lateinit var bannersRecyclerView: RecyclerView
    lateinit var bannersadapter: BannersAdapter
//    private val adapter: DishesAdapter() {
//        clickDish()  // тут тоже не оч понятно
//    }
    private val launcher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            Toast.makeText(context, "permissions is $isGranted", Toast.LENGTH_SHORT).show()
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDishesViewModel()
        initCategoriesViewModel()
        banners()
    }

    private fun initDishesViewModel() {
        val menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        menuViewModel.initDishesDatabase()
        if (context?.let { menuViewModel.internetCheck(it) } == true) {
            menuViewModel.getDishesListData()
        }

        binding.apply {
            qr_code.setOnClickListener {
                checkPermissions()
                startActivity(Intent(context, ScannerActivity::class.java))
            }
        }

        menuViewModel.getDishesObserver().observe(viewLifecycleOwner) {

            val items = it.meals.size
            Log.d("items", "$items")
            for (item in 0 until items) {
                menuViewModel.dishesInsert(
                    Meal(
                        idMeal = it.meals[item].idMeal,
                        strMeal = it.meals[item].strMeal,
                        strMealThumb = it.meals[item].strMealThumb,
                        priceDishes = Random.nextInt(300, 500).toString()
                    )
                )
            }
        }

        dishesRecyclerView = binding.dishesRecyclerView
        dishesadapter = DishesAdapter() // зачем это?
        dishesRecyclerView.adapter = dishesadapter

        menuViewModel.menuDishesLiveData.observe(viewLifecycleOwner) {
            Log.d("Result2", "$it")
        }

        menuViewModel.getDishesAllNotes().observe(viewLifecycleOwner) {
            dishesadapter.setDishesList(it)
        }
    }

    private fun initCategoriesViewModel() {
        val menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        menuViewModel.initCategoriesDatabase()
        if (context?.let { menuViewModel.internetCheck(it) } == true) {
            menuViewModel.getCategoriesListData()
        }

        menuViewModel.getCategoriesObserver().observe(viewLifecycleOwner) {

            val items = it.categories.size
            for (item in 0 until items) {
                menuViewModel.categoriesInsert(
                    Category(
                        idCategory = it.categories[item].idCategory,
                        strCategory = it.categories[item].strCategory,
                    )
                )
            }
        }

        categoriesRecyclerView = binding.categoriesRecyclerView
        categoriesadapter = CategoriesAdapter()
        categoriesRecyclerView.adapter = categoriesadapter

        menuViewModel.getCategoriesAllNotes().observe(viewLifecycleOwner) {
            categoriesadapter.setCategoriesList(it)
        }
    }

    private fun banners() {
        val banner = Banners.getBannerList()

        bannersRecyclerView = binding.bannerRecyclerView
        bannersadapter = BannersAdapter()
        bannersRecyclerView.adapter = bannersadapter
        bannersadapter.setBannersList(banner)
    }

//    private fun clickDish(dish: MealDish) {
//        val fragmentBasket = DishFragment.newInstance(dish.idMeal)
//
//        parentFragmentManager
//            .beginTransaction()
//            .replace(R.id.basketFragment, fragmentBasket)
//            .addToBackStack(null)
//            .commit()
//    }

    private fun checkPermissions() {
        if (context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.CAMERA
                )
            } == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "permissions is Granted", Toast.LENGTH_SHORT).show()
        } else {
            launcher.launch(Manifest.permission.CAMERA)
        }
    }
}