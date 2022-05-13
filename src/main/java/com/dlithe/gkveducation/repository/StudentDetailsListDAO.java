package com.dlithe.gkveducation.repository;
import com.dlithe.gkveducation.entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDetailsListDAO extends  JpaRepository<StudentDetail, Integer>{

    @Query(value = "SELECT * FROM student_details where school_standard_id =?1", nativeQuery = true)
    List<StudentDetail> findBySchoolStandardId(int schoolStandardId);

    @Query(value = "SELECT * FROM student_details where school_standard_id =?1", nativeQuery = true)
    List<StudentDetail> findBySchoolStandardIdAllStudents(int schoolStandardId);
}
