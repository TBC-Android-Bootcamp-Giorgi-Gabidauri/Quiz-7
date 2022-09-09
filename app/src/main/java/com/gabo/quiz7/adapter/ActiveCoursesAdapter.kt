package com.gabo.quiz7.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
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
                tvTitle.text = model.title
                tvSubText.text = model.bookingTime
                ivIcon.loadImage(model.image)
                cl.setBackgroundColor(Color.parseColor("#${model.mainColor}"))
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