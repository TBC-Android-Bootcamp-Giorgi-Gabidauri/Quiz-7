package com.gabo.quiz7.data.repository

import com.gabo.quiz7.data.api.CoursesApi
import com.gabo.quiz7.domain.models.CoursesModel
import com.gabo.quiz7.domain.repository.CoursesRepository
import com.gabo.quiz7.extensions.toModel
import com.gabo.quiz7.other.ResponseHandler
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(private val coursesApi: CoursesApi) :
    CoursesRepository {
    override suspend fun getCourses(): ResponseHandler<CoursesModel> {
        return try {
            val result = coursesApi.getCourses()
            when {
                result.isSuccessful -> {
                    val body = result.body()
                    ResponseHandler.Success(body?.toModel())
                }
                else -> {
                    val errorMsg = result.errorBody()?.string()
                    ResponseHandler.Error(errorMsg)
                }
            }
        } catch (e: Exception) {
            ResponseHandler.Error("Unexpected error occurred")
        }
    }
}