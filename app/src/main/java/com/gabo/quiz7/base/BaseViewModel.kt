package com.gabo.quiz7.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabo.quiz7.domain.models.CoursesModel
import com.gabo.quiz7.other.ResponseHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T : Any> : ViewModel() {
    protected val _defaultState = MutableStateFlow(DefaultViewState<T>())
    open val defaultState = _defaultState.asStateFlow()

    protected suspend fun getData(
        flow: Flow<ResponseHandler<T>>,
        success: ((ResponseHandler.Success<T>) -> (Unit))?,
    ) {
        flow.collect {
            _defaultState.value = _defaultState.value.copy(loading = true)
            when (it) {
                is ResponseHandler.Success -> {
                    _defaultState.value = _defaultState.value.copy(
                        loading = false,
                        data = it.data
                    )
                    success?.invoke(it)
                }
                is ResponseHandler.Error -> {
                    _defaultState.value = _defaultState.value.copy(
                        loading = false,
                        errorMsg = it.errorMsg ?: "Something went wrong"
                    )
                }
            }
        }
    }

    data class DefaultViewState<T>(
        val loading: Boolean = false,
        val data: T? = null,
        val errorMsg: String = ""
    )
}