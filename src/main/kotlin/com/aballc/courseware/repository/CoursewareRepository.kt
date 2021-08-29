package com.aballc.courseware.repository

import javax.enterprise.context.ApplicationScoped

import com.aballc.courseware.entity.CourseEntity
import io.quarkus.hibernate.orm.panache.PanacheRepository

@ApplicationScoped
class CoursewareRepository : PanacheRepository<CourseEntity> {
}
