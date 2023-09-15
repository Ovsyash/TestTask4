package HammerSystems.tasktest4.fragments.basket.adapter

import HammerSystems.tasktest4.data.dishes.Meal
import HammerSystems.tasktest4.databinding.DishesBinding
import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@Suppress("UNREACHABLE_CODE")
class BasketAdapter() : RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {

    var listDishes = emptyList<Meal>()

    class BasketViewHolder(val binding: DishesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val binding =
            DishesBinding.inflate(LayoutInflater.from(parent.context))
        return BasketViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val item = listDishes[position]
        Log.d("item", item.toString())
        holder.binding.apply {
            titleDish.text = item.strMeal
            priceDishes.text = "${item.priceDishes} р"
            Glide.with(imageDish)
                .load(item.strMealThumb)
                .into(imageDish)
        }
    }

    override fun getItemCount(): Int {
        return listDishes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDishesList(list: List<Meal>) {
        listDishes = list
        notifyDataSetChanged()
    }
}