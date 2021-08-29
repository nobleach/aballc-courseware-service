package com.aballc.courseware.service

import com.aballc.courseware.repository.CoursewareRepository
import javax.inject.Inject
import javax.enterprise.context.ApplicationScoped
import javax.transaction.Transactional
import java.time.ZonedDateTime

import com.aballc.courseware.entity.CourseEntity
import com.aballc.courseware.dto.CourseDto

@ApplicationScoped
class CoursewareService(
  @Inject
  private val coursewareRepository: CoursewareRepository,
) {
  fun getAllCourses(): List<CourseDto> {
    val courses = coursewareRepository.listAll()
    return courses.map { it ->
      CourseDto(
        id = it.id!!,
        courseName = it.courseName,
        description = it.description,
        thumbnail = it.thumbnail,
      )
    }
  }

  @Transactional
  fun saveCourse(course: CourseDto): Unit {
    val courseEntity = CourseEntity(
      id = null,
      courseName = course.courseName,
      description = course.description,
      thumbnail = course.thumbnail,
      createdTimestamp = ZonedDateTime.now(),
      modifiedTimestamp = ZonedDateTime.now(),
    )

    coursewareRepository.persist(courseEntity)
  }
}
