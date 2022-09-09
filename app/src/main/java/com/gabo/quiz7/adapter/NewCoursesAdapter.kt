package com.gabo.quiz7.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabo.quiz7.R
import com.gabo.quiz7.databinding.NewCoursesItemViewBinding
import com.gabo.quiz7.domain.models.NewCoursesModel

class NewCoursesAdapter() : RecyclerView.Adapter<NewCoursesAdapter.NewCoursesVH>() {
    private var list: List<NewCoursesModel> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<NewCoursesModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class NewCoursesVH(private val binding: NewCoursesItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: NewCoursesModel) {
            with(binding) {
                if (model.iconType == "settings") {
                    icIntroduce.setImageResource(R.drawable.ic_settings)
                } else {
                    icIntroduce.setImageResource(R.drawable.ic_wallet)
                }
                cl.setBackgroundColor(Color.parseColor("#${model.mainColor}"))
                tvIntroduce.text = model.title
                tvTime.text = model.duration.toString()
                tvWhatIsIt.text = model.question
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCoursesVH {
        val binding =
            NewCoursesItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewCoursesVH(binding)
    }

    override fun onBindViewHolder(holder: NewCoursesVH, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size
}