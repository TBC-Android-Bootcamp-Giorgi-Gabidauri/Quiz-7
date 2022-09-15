package com.gabo.quiz7.di

import com.gabo.quiz7.domain.useCases.GetCoursesUseCaseImpl
import com.gabo.quiz7.ui.useCases.GetCoursesUseCase
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
    abstract fun bindGetCoursesUseCase(getCoursesUseCaseImpl: GetCoursesUseCaseImpl): GetCoursesUseCase
}