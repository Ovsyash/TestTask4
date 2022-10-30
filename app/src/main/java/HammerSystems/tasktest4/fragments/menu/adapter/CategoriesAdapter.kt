package HammerSystems.tasktest4.fragments.menu.adapter

import HammerSystems.tasktest4.R
import HammerSystems.tasktest4.data.categories.Category
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.categories.view.*

class CategoriesAdapter() : RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder>() {

    var listCategories = emptyList<Category>()

    class CategoriesHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories, parent, false)

        return CategoriesHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesHolder, position: Int) {

        holder.itemView.apply {
            title_category.text = listCategories[position].strCategory
        }
    }

    override fun getItemCount(): Int {
        return listCategories.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCategoriesList(list: List<Category>) {
        listCategories = list
        notifyDataSetChanged()
    }

}