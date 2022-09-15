package com.gabo.quiz7.domain.models

import com.gabo.quiz7.data.models.ActiveCoursesDto
import com.gabo.quiz7.data.models.NewCoursesDto

data class CoursesModel(
    val newCourses: List<NewCoursesDto>,
    val activeCourses: List<ActiveCoursesDto>
)