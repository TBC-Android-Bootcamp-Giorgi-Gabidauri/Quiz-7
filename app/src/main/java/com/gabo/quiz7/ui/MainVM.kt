package com.gabo.quiz7.ui

import androidx.lifecycle.ViewModel
import com.gabo.quiz7.domain.models.ActiveCoursesModel
import com.gabo.quiz7.domain.models.NewCoursesModel
import com.gabo.quiz7.domain.useCases.GetActiveCoursesUseCase
import com.gabo.quiz7.domain.useCases.GetNewCoursesUseCase
import com.gabo.quiz7.other.ResponseHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val getActiveCoursesUseCase: GetActiveCoursesUseCase,
    private val getNewCoursesUseCase: GetNewCoursesUseCase
) : ViewModel() {
    fun getActiveCourses() = flow<ResponseHandler<List<ActiveCoursesModel>>> {
        emit(getActiveCoursesUseCase(Unit))
    }

    fun getNewCourses() = flow<ResponseHandler<List<NewCoursesModel>>> {
        emit(getNewCoursesUseCase(Unit))
    }

}