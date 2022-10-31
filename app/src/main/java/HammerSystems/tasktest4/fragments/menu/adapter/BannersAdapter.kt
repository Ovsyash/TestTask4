package HammerSystems.tasktest4.fragments.menu.adapter

import HammerSystems.tasktest4.R
import HammerSystems.tasktest4.data.banners.Banner
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.banners.view.*

class BannersAdapter() : RecyclerView.Adapter<BannersAdapter.BannersViewHolder>() {

    var listBanners = emptyList<Banner>()

    class BannersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.banners, parent, false)
        return BannersViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannersViewHolder, position: Int) {

        holder.itemView.apply {
            Glide.with(this)
                .load(listBanners[position].imageBanner)
                .into(image_banner)
        }
    }

    override fun getItemCount(): Int {
        return listBanners.size
    }

    fun setBannersList(list: List<Banner>) {
        listBanners = list
    }
}