package com.gabo.quiz7.data.repository

import com.gabo.quiz7.data.api.CoursesApi
import com.gabo.quiz7.data.models.CoursesDto
import com.gabo.quiz7.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val coursesApi: CoursesApi): Repository {
    override suspend fun getCourses(): Response<CoursesDto> {
        return coursesApi.getCourses()
    }
}