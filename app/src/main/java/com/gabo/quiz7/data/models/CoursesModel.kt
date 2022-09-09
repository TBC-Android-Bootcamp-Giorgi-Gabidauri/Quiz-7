package com.gabo.quiz7.data.models

import com.google.gson.annotations.SerializedName

data class CoursesModel (
    @SerializedName("new_courses")
    val newCourses: List<NewCoursesModel>,
    @SerializedName("active_courses")
    val activeCourses: List<ActiveCoursesModel>,

)
