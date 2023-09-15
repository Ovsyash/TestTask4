package HammerSystems.tasktest4.fragments.basket.model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import HammerSystems.tasktest4.R
import HammerSystems.tasktest4.ScannerActivity
import HammerSystems.tasktest4.data.dishes.Meal
import HammerSystems.tasktest4.databinding.FragmentBasketBinding
import HammerSystems.tasktest4.fragments.menu.model.MenuViewModel
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_menu.qr_code
import kotlin.random.Random

class BasketFragment : Fragment() {

    lateinit var binding: FragmentBasketBinding
    lateinit var dishesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBasketBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}