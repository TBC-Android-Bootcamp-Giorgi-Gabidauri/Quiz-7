package com.gabo.quiz7.ui

import androidx.lifecycle.viewModelScope
import com.gabo.quiz7.base.BaseViewModel
import com.gabo.quiz7.domain.models.ActiveCoursesModel
import com.gabo.quiz7.domain.models.CoursesModel
import com.gabo.quiz7.domain.models.NewCoursesModel
import com.gabo.quiz7.extensions.toModel
import com.gabo.quiz7.ui.useCases.GetCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(private val getCoursesUseCase: GetCoursesUseCase) :
    BaseViewModel<CoursesModel>() {

    private val _state: MutableStateFlow<ViewState> = MutableStateFlow(ViewState())
    val state = _state.asStateFlow()

    init {
        getCourses()
    }

    private fun getCourses() {
        viewModelScope.launch {
            val courses = getCoursesUseCase(Unit)
            getData(courses) {
                _state.value = _state.value.copy(
                    activeCourses = _defaultState.value.data?.activeCourses?.map { it.toModel() }
                        ?: emptyList(),
                    newCourses = _defaultState.value.data?.newCourses?.map { it.toModel() }
                        ?: emptyList()
                )
            }
        }
    }

    data class ViewState(
        val activeCourses: List<ActiveCoursesModel> = emptyList(),
        val newCourses: List<NewCoursesModel> = emptyList()
    )
}