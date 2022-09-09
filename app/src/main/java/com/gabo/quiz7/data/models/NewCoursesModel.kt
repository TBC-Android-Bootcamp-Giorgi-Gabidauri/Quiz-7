package com.gabo.quiz7.data.models

import com.google.gson.annotations.SerializedName

data class NewCoursesModel(
    val id: Int,
    @SerializedName("icon_type")
    val iconType: String,
    val duration: Long,
    val title: String,
    val question: String,
    @SerializedName("main_color")
    val mainColor: String
)