package com.gabo.quiz7.base

abstract class BaseUseCase<Params, Result> {
    abstract suspend operator fun invoke(params: Params): Result
}