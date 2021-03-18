## Part 1: Test it with SQL

SELECT id, employer, name, skills
FROM job

id = int,
employer = varchar(255),
name = varchar(255),
skills = varchar(255)

## Part 2: Test it with SQL

SELECT name
FROM employer
WHERE location = "St. Louis City"

## Part 3: Test it with SQL

DROP TABLE job_skills
DROP TABLE job

## Part 4: Test it with SQL

SELECT *
FROM skill
INNER JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id is not null
ORDER BY name ASC