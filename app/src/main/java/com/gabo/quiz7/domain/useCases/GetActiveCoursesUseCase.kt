package com.gabo.quiz7.domain.useCases

import com.gabo.quiz7.base.BaseUseCase
import com.gabo.quiz7.domain.models.ActiveCoursesModel
import com.gabo.quiz7.domain.repository.Repository
import com.gabo.quiz7.extensions.toModel
import com.gabo.quiz7.other.ResponseHandler
import javax.inject.Inject

class GetActiveCoursesUseCase @Inject constructor(private val repository: Repository) :
    BaseUseCase<Unit, ResponseHandler<List<ActiveCoursesModel>>>() {
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