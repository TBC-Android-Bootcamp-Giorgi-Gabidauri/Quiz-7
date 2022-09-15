package com.gabo.quiz7.di

import com.gabo.quiz7.data.repository.CoursesRepositoryImpl
import com.gabo.quiz7.domain.repository.CoursesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(coursesRepositoryImpl: CoursesRepositoryImpl): CoursesRepository
}
