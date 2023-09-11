package HammerSystems.tasktest4.fragments.menu.adapter

import HammerSystems.tasktest4.data.dishes.Meal
import HammerSystems.tasktest4.databinding.DishesBinding
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dishes.view.*

@Suppress("UNREACHABLE_CODE")
class DishesAdapter(
//    val clickDish: (Meal) -> Unit // Пока непонятно как реализовать анонимную функцию
) : RecyclerView.Adapter<DishesAdapter.DishesViewHolder>() {

    var listDishes = emptyList<Meal>()

    class DishesViewHolder(val binding: DishesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
        val binding =
            DishesBinding.inflate(LayoutInflater.from(parent.context))
        return DishesViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
        val item = listDishes[position]
        holder.binding.apply {
//            root.setOnClickListener { clickDish(item) } //Почему-то не определяется item
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