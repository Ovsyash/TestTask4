package HammerSystems.tasktest4.fragments.dishe

import HammerSystems.tasktest4.R
import HammerSystems.tasktest4.databinding.FragmentDisheBinding
import HammerSystems.tasktest4.databinding.FragmentMenuBinding
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import androidx.fragment.app.Fragment

private const val ARG_URL_DISHE = "ARG_URL_DISHE"

class DisheFragment : Fragment() {
    lateinit var binding: FragmentDisheBinding
    private lateinit var disheViewModel: DisheViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDisheBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDisheViewModel()
    }

    private fun initDisheViewModel() {
        disheViewModel = ViewModelProvider(this).get(DisheViewModel::class.java)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            val dishe = disheViewModel.getItemDishe(getUrlDishe())

            binding.apply {
                titleDishe.text = getString(R.string.strMeal, dishe.strMeal)
                countryDishe.text = getString(R.string.strArea, dishe.strArea)
                categoryDishe.text = getString(R.string.strCategory, dishe.strCategory)
                ingredientsDishe.text = getString(R.string.strIngredient1, dishe.strIngredient1)
                instructionDishe.text = getString(R.string.strInstructions, dishe.strInstructions)

                Glide.with(photoDish)
                    .load(dishe.strMealThumb)
                    .into(photoDish)
            }
        }
    }

    private fun getUrlDishe(): Int = requireArguments().getInt(ARG_URL_DISHE)

    companion object {
        fun newInstance(urlDishe: Int): DisheFragment {
            val args = Bundle().apply {
                putInt(ARG_URL_DISHE, urlDishe)
            }

            val fragment = DisheFragment()
            fragment.arguments = args
            return fragment
        }
    }
}




