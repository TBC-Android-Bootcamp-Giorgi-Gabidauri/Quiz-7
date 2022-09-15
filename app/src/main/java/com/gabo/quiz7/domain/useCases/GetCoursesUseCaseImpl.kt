package com.gabo.quiz7.domain.useCases

import com.gabo.quiz7.domain.repository.CoursesRepository
import com.gabo.quiz7.ui.useCases.GetCoursesUseCase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoursesUseCaseImpl @Inject constructor(private val coursesRepository: CoursesRepository) :
    GetCoursesUseCase {
    override suspend fun invoke(params: Unit) = flow {
        emit(coursesRepository.getCourses())
    }
}