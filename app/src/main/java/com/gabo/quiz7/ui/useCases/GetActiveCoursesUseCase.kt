package com.gabo.quiz7.ui.useCases

import com.gabo.quiz7.base.BaseUseCase
import com.gabo.quiz7.domain.models.ActiveCoursesModel
import com.gabo.quiz7.other.ResponseHandler

interface GetActiveCoursesUseCase: BaseUseCase<Unit, ResponseHandler<List<ActiveCoursesModel>>> {
    override suspend fun invoke(params: Unit): ResponseHandler<List<ActiveCoursesModel>>
}