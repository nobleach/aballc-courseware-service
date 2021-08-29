package com.aballc.courseware.dto

import java.util.UUID

data class CourseDto(
  var id: UUID?,
  val courseName: String,
  val description: String,
  val thumbnail: String,
)
