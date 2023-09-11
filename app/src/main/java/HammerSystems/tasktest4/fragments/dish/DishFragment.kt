package HammerSystems.tasktest4.fragments.dish

import HammerSystems.tasktest4.R
import HammerSystems.tasktest4.databinding.FragmentDishBinding
import android.os.Bundle
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

        initDisheViewModel()
    }

    private fun initDisheViewModel() {
        dishViewModel = ViewModelProvider(this).get(DishViewModel::class.java)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            val dishe = getUrlDish()?.let { dishViewModel.getItemDishe(it) } //После того как заменил везде тип параметра id с Int на String пришлось добавить проверку на null

            binding.apply {
                titleDish.text = getString(R.string.strMeal, dishe?.strMeal)//После того как заменил везде тип параметра id с Int на String пришлось добавить проверку на null
                countryDish.text = getString(R.string.strArea, dishe?.strArea)//После того как заменил везде тип параметра id с Int на String пришлось добавить проверку на null
                categoryDish.text = getString(R.string.strCategory, dishe?.strCategory)//После того как заменил везде тип параметра id с Int на String пришлось добавить проверку на null
                ingredientsDish.text = getString(R.string.strIngredient1, dishe?.strIngredient1)//После того как заменил везде тип параметра id с Int на String пришлось добавить проверку на null
                instructionDish.text = getString(R.string.strInstructions, dishe?.strInstructions)//После того как заменил везде тип параметра id с Int на String пришлось добавить проверку на null

                Glide.with(photoDish)
                    .load(dishe?.strMealThumb)
                    .into(photoDish)
            }
        }
    }

    private fun getUrlDish() = requireArguments().getString(ARG_URL_DISH)//После того как заменил везде тип параметра id с Int на String пришлось добавить проверку на null

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




