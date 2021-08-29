CREATE TABLE courses
(
  id                        UUID CONSTRAINT course_id_pkey PRIMARY KEY,
  course_name               TEXT                           NOT NULL,
  description               TEXT                           NOT NULL,
  thumbnail                 TEXT,
  created_ts                TIMESTAMPTZ DEFAULT Now()      NOT NULL,
  modified_ts               TIMESTAMPTZ DEFAULT Now()
);

