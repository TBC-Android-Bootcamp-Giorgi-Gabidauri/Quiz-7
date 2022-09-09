package com.gabo.quiz7.data.api

import com.gabo.quiz7.constants.COURSES_END_POINT
import com.gabo.quiz7.data.models.CoursesModel
import retrofit2.Response
import retrofit2.http.GET

interface CoursesApi {

    @GET(COURSES_END_POINT)
    suspend fun getCourses(): Response<CoursesModel>

}