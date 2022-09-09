package com.gabo.quiz7.domain.models

data class ActiveCoursesModel(
    val id: Int,
    val bookingTime: String,
    val progress: Int,
    val title: String,
    val mainColor: String,
    val backgroundColorPercent: Int,
    val playButtonColorPercent: Int,
    val image: String
)