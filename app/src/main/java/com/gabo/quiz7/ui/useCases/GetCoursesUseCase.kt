package com.gabo.quiz7.ui.useCases

import com.gabo.quiz7.base.BaseUseCase
import com.gabo.quiz7.domain.models.CoursesModel
import com.gabo.quiz7.other.ResponseHandler
import kotlinx.coroutines.flow.Flow

interface GetCoursesUseCase : BaseUseCase<Unit, Flow<ResponseHandler<CoursesModel>>> {
    override suspend fun invoke(params: Unit): Flow<ResponseHandler<CoursesModel>>
}