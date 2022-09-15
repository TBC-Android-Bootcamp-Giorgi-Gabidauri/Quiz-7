package com.gabo.quiz7.data.models

import com.google.gson.annotations.SerializedName

data class CoursesDto(
    @SerializedName("new_courses")
    val newCourses: List<NewCoursesDto>,
    @SerializedName("active_courses")
    val activeCourses: List<ActiveCoursesDto>
)
