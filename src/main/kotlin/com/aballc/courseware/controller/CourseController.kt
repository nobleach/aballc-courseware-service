package com.aballc.controller

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.DELETE
import javax.ws.rs.PathParam
import javax.inject.Inject
import java.util.UUID
import javax.transaction.Transactional

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

    @GET
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getCourseById(@PathParam("courseId") courseId: UUID): CourseDto {
      return coursewareService.getById(courseId)
    }

    @POST
    @Transactional
    fun saveCourse(course: CourseDto) {
      return coursewareService.saveCourse(course)
    }

    @PUT
    @Path("/{courseId}")
    @Transactional
    fun updateCourseById(@PathParam("courseId") courseId: UUID, course: CourseDto): CourseDto {

    }

    @DELETE
    @Path("/{courseId}")
    @Transactional
    fun deleteCourseById(@PathParam("courseId") courseId: UUID) {

    }
}

