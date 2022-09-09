package com.gabo.quiz7.domain.models

data class NewCoursesModel(
    val id: Int,
    val iconType: String,
    val duration: Long,
    val title: String,
    val question: String,
    val mainColor: String
)