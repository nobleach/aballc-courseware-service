package com.aballc.controller

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.POST
import javax.inject.Inject

import com.aballc.courseware.dto.CourseDto
import com.aballc.courseware.service.CoursewareService

@Path("/course")
class CourseResource(
  @Inject private val coursewareService: CoursewareService,
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllCourses(): List<CourseDto> {
      return coursewareService.getAllCourses()
    }

    @POST
    fun saveCourse(course: CourseDto) {
      return coursewareService.saveCourse(course)
    }
}

