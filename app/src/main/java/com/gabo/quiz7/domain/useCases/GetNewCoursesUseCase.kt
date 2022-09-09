package com.gabo.quiz7.domain.useCases

import com.gabo.quiz7.base.BaseUseCase
import com.gabo.quiz7.data.models.NewCoursesModel
import com.gabo.quiz7.domain.repository.Repository
import com.gabo.quiz7.other.ResponseHandler
import javax.inject.Inject

class GetNewCoursesUseCase @Inject constructor(private val repository: Repository) :
    BaseUseCase<Unit, ResponseHandler<List<NewCoursesModel>>>() {
    override suspend fun invoke(params: Unit): ResponseHandler<List<NewCoursesModel>> {
        val result = repository.getCourses()
        return when {
            result.isSuccessful -> {
                val body = result.body()
                ResponseHandler.Success(body?.newCourses)
            }
            else -> {
                val errorMsg = result.errorBody()?.string()
                ResponseHandler.Error(errorMsg)
            }
        }
    }
}