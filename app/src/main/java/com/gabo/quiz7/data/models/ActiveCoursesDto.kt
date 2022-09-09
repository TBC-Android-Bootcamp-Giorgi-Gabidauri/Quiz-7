package com.gabo.quiz7.data.models

import com.google.gson.annotations.SerializedName

data class ActiveCoursesDto(
    val id: Int,
    @SerializedName("booking_time")
    val bookingTime: String,
    val progress: Int,
    val title: String,
    @SerializedName("main_color")
    val mainColor: String,
    @SerializedName("background_color_percent")
    val backgroundColorPercent: Int,
    @SerializedName("play_button_color_percent")
    val playButtonColorPercent: Int,
    val image: String
)
