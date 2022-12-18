package com.aballc.courseware.repository

import javax.enterprise.context.ApplicationScoped
import java.util.UUID

import com.aballc.courseware.entity.CourseEntity
import io.quarkus.hibernate.orm.panache.PanacheRepository

@ApplicationScoped
class CoursewareRepository : PanacheRepository<CourseEntity> {
  fun findById(courseId: UUID): CourseEntity {
    return find("id", courseId).firstResult()
  }
}
