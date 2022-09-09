package com.gabo.quiz7.domain.repository

import com.gabo.quiz7.data.models.CoursesModel
import retrofit2.Response

interface Repository {
    suspend fun getCourses(): Response<CoursesModel>
}