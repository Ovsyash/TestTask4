package HammerSystems.tasktest4.fragments.dish

import HammerSystems.tasktest4.R
import HammerSystems.tasktest4.databinding.FragmentDishBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import androidx.fragment.app.Fragment

private const val ARG_URL_DISH = "ARG_URL_DISH"

class DishFragment : Fragment() {
    lateinit var binding: FragmentDishBinding
    private lateinit var dishViewModel: DishViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDishBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDishViewModel()
    }

    private fun initDishViewModel() {
        dishViewModel = ViewModelProvider(this).get(DishViewModel::class.java)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            val dish = getUrlDish()?.let { dishViewModel.getItemDish(it)
           }
            Log.d("test", dish.toString())
            Log.d("test2", getUrlDish().toString())
            Log.d("test3", dishViewModel.getItemDish("52874").toString())

            binding.apply {
                titleDish.text = getString(R.string.strMeal, dish?.strMeal)
//                Log.d("test", dish.toString())
                countryDish.text = getString(R.string.strArea, dish?.strArea)
                categoryDish.text = getString(R.string.strCategory, dish?.strCategory)
                ingredientsDish.text = getString(R.string.strIngredient1, dish?.strIngredient1)
                instructionDish.text = getString(R.string.strInstructions, dish?.strInstructions)

                Glide.with(photoDish)
                    .load(dish?.strMealThumb)
                    .into(photoDish)
            }
        }
    }

    private fun getUrlDish(): String? = requireArguments().getString(ARG_URL_DISH)

    companion object {
        fun newInstance(urlDish: String): DishFragment {
            val args = Bundle().apply {
                putString(ARG_URL_DISH, urlDish)
            }

            val fragment = DishFragment()
            fragment.arguments = args
            return fragment
        }
    }
}




