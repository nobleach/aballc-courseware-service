package com.aballc.courseware.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.Table
import java.time.ZonedDateTime
import java.util.UUID
import org.hibernate.annotations.Type
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "courses")
data class CourseEntity(
  @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
  @GeneratedValue(generator = "UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  @Id
  var id: UUID?,

  @Column(name = "course_name")
  val courseName: String,

  val description: String,

  val thumbnail: String,

  @Column(name = "created_ts")
  val createdTimestamp: ZonedDateTime? = ZonedDateTime.now(),

  @Column(name = "modified_ts")
  val modifiedTimestamp: ZonedDateTime? = ZonedDateTime.now()
)
