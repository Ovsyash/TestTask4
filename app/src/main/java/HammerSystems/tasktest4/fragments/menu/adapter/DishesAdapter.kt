package HammerSystems.tasktest4.fragments.menu.adapter

import HammerSystems.tasktest4.R
import HammerSystems.tasktest4.data.dishe.Dishe
import HammerSystems.tasktest4.data.dishes.Meal
import HammerSystems.tasktest4.fragments.dishe.DisheFragment
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dishes.view.*
import kotlinx.android.synthetic.main.fragment_menu.view.qr_code
import kotlin.random.Random

@Suppress("UNREACHABLE_CODE")
class DishesAdapter() : RecyclerView.Adapter<DishesAdapter.DishesHolder>() {

    var listDishes = emptyList<Meal>()

    class DishesHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dishes, parent, false)

        return DishesHolder(view)
    }

    override fun onBindViewHolder(holder: DishesHolder, position: Int) {

        holder.itemView.apply {
            title_dish.text = listDishes[position].strMeal
            price_dishes.text = "${listDishes[position].priceDishes} р"
            Glide.with(this)
                .load(listDishes[position].strMealThumb)
                .into(image_dish)
        }

//        holder.itemView.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                lateinit var dishesItem: HammerSystems.tasktest4.data.dishe.Meal
//
//                val activity = v!!.context as AppCompatActivity
//                val fragmentBasket = DisheFragment.newInstance(urlDishe = dishesItem.idMeal.toInt())
//                activity.supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.basketFragment, fragmentBasket)
//                    .addToBackStack(null)
//                    .commit()
//            }
//        })
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