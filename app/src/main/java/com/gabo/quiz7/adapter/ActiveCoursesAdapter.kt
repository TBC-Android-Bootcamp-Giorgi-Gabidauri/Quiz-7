package com.gabo.quiz7.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.alpha
import androidx.recyclerview.widget.RecyclerView
import com.gabo.quiz7.data.models.ActiveCoursesModel
import com.gabo.quiz7.databinding.ActiveCoursesItemViewBinding
import com.gabo.quiz7.extensions.loadImage

class ActiveCoursesAdapter() :
    RecyclerView.Adapter<ActiveCoursesAdapter.ActiveCoursesVH>() {
    private var list: List<ActiveCoursesModel> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<ActiveCoursesModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ActiveCoursesVH(private val binding: ActiveCoursesItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ActiveCoursesModel) {
            with(binding) {
                val color = Color.parseColor("#${model.mainColor}")
                tvTitle.text = model.title
                tvTitle.setTextColor(color)
                ivIcon.loadImage(model.image)
                ivIcon.setBackgroundColor(color)
                clIcon.setBackgroundColor(color)
                tvSubText.text = model.bookingTime
                tvSubText.setTextColor(color)
                cl.setBackgroundColor(color)
                cl.background.alpha = model.backgroundColorPercent
                ivStart.setColorFilter(color)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveCoursesVH {
        val binding =
            ActiveCoursesItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActiveCoursesVH(binding)
    }

    override fun onBindViewHolder(holder: ActiveCoursesVH, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size
}