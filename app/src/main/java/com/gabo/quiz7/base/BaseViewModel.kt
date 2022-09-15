package com.gabo.quiz7.base

import androidx.lifecycle.ViewModel
import com.gabo.quiz7.other.ResponseHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<T : Any> : ViewModel() {
    protected val _defaultState = MutableStateFlow(DefaultViewState<T>())
    open val defaultState = _defaultState.asStateFlow()

    open suspend fun getData(
        flow: Flow<ResponseHandler<T>>,
        success: ((ResponseHandler.Success<T>) -> (Unit))?,
        error: ((ResponseHandler.Error<T>) -> (Unit))?
    ) {
        flow.collect {
            resetDefaultViewState()
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
                    error?.invoke(it)
                }
            }
        }
    }
    private fun resetDefaultViewState(){
        _defaultState.value = DefaultViewState()
    }
    abstract fun resetViewState()

    data class DefaultViewState<T>(
        val loading: Boolean = false,
        val data: T? = null,
        val errorMsg: String = ""
    )
}