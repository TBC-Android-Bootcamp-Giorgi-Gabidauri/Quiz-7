package com.gabo.quiz7.base

interface BaseUseCase<Params, Result> {
     suspend operator fun invoke(params: Params): Result
}