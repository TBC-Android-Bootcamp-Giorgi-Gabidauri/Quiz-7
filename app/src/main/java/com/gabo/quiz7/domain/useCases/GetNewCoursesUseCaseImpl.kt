package com.gabo.quiz7.domain.useCases

import com.gabo.quiz7.domain.models.NewCoursesModel
import com.gabo.quiz7.domain.repository.Repository
import com.gabo.quiz7.extensions.toModel
import com.gabo.quiz7.other.ResponseHandler
import com.gabo.quiz7.ui.useCases.GetNewCoursesUseCase
import javax.inject.Inject

class GetNewCoursesUseCaseImpl @Inject constructor(private val repository: Repository) :
    GetNewCoursesUseCase {
    override suspend fun invoke(params: Unit): ResponseHandler<List<NewCoursesModel>> {
        val result = repository.getCourses()
        return when {
            result.isSuccessful -> {
                val body = result.body()
                ResponseHandler.Success(body?.newCourses?.map { it.toModel() })
            }
            else -> {
                val errorMsg = result.errorBody()?.string()
                ResponseHandler.Error(errorMsg)
            }
        }
    }
}