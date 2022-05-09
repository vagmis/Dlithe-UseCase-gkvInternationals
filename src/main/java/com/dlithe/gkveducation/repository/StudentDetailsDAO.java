package com.dlithe.gkveducation.repository;

import com.dlithe.gkveducation.entity.StudentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailsDAO  extends JpaRepository<StudentDetailsEntity, Integer> {

    @Query(value = "SELECT * FROM student_details WHERE student_details_id=?1 AND student_roll_number=?2", nativeQuery = true)
    StudentDetailsEntity findStudentIdAndRollNumber(int studentDetailsId, int studentRollNumber);

}
