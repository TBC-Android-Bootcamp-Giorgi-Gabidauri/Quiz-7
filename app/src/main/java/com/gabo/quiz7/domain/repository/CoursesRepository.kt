package com.gabo.quiz7.domain.repository

import com.gabo.quiz7.domain.models.CoursesModel
import com.gabo.quiz7.other.ResponseHandler

interface CoursesRepository {
    suspend fun getCourses(): ResponseHandler<CoursesModel>
}