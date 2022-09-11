package com.gabo.quiz7.di

import com.gabo.quiz7.domain.useCases.GetActiveCoursesUseCaseImpl
import com.gabo.quiz7.domain.useCases.GetNewCoursesUseCaseImpl
import com.gabo.quiz7.ui.useCases.GetActiveCoursesUseCase
import com.gabo.quiz7.ui.useCases.GetNewCoursesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindGetActiveCoursesUseCase(getActiveCoursesUseCaseImpl: GetActiveCoursesUseCaseImpl): GetActiveCoursesUseCase

    @Binds
    @Singleton
    abstract fun bindGetNewCoursesUseCase(getNewCoursesUseCaseImpl: GetNewCoursesUseCaseImpl): GetNewCoursesUseCase
}