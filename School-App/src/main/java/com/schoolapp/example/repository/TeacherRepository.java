package com.schoolapp.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolapp.example.entities.Teacher;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	@Query("SELECT t.teacherName FROM Teacher t WHERE t.age > :age")
	List<String> findTeacherNamesByAgeGreaterThan(@Param("age") int age);
	@Query(value = "SELECT * FROM teacher WHERE qualification = :qualification", nativeQuery = true)
	List<Teacher> findByQualificationNative(@Param("qualification") String qualification);


}
