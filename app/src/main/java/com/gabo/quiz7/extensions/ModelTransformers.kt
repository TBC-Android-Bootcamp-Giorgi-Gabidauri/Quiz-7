package com.gabo.quiz7.extensions

import com.gabo.quiz7.data.models.ActiveCoursesDto
import com.gabo.quiz7.data.models.NewCoursesDto
import com.gabo.quiz7.domain.models.ActiveCoursesModel
import com.gabo.quiz7.domain.models.NewCoursesModel


fun ActiveCoursesDto.toModel(): ActiveCoursesModel = ActiveCoursesModel(
    id,
    bookingTime,
    progress,
    title,
    mainColor,
    backgroundColorPercent,
    playButtonColorPercent,
    image
)

fun NewCoursesDto.toModel(): NewCoursesModel = NewCoursesModel(
    id, iconType, duration, title, question, mainColor
)