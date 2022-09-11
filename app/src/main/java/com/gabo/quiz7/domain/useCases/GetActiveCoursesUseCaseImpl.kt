package com.gabo.quiz7.domain.useCases

import com.gabo.quiz7.domain.models.ActiveCoursesModel
import com.gabo.quiz7.domain.repository.Repository
import com.gabo.quiz7.extensions.toModel
import com.gabo.quiz7.other.ResponseHandler
import com.gabo.quiz7.ui.useCases.GetActiveCoursesUseCase
import javax.inject.Inject

class GetActiveCoursesUseCaseImpl @Inject constructor(private val repository: Repository) :
    GetActiveCoursesUseCase {
    override suspend fun invoke(params: Unit): ResponseHandler<List<ActiveCoursesModel>> {
        val result = repository.getCourses()
        return when {
            result.isSuccessful -> {
                val body = result.body()
                ResponseHandler.Success(body?.activeCourses?.map { it.toModel() })
            }
            else -> {
                val errorMsg = result.errorBody()?.string()
                ResponseHandler.Error(errorMsg)
            }
        }
    }
}