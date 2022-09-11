package com.gabo.quiz7.ui.useCases

import com.gabo.quiz7.base.BaseUseCase
import com.gabo.quiz7.domain.models.NewCoursesModel
import com.gabo.quiz7.other.ResponseHandler

interface GetNewCoursesUseCase: BaseUseCase<Unit, ResponseHandler<List<NewCoursesModel>>> {
    override suspend fun invoke(params: Unit): ResponseHandler<List<NewCoursesModel>>
}