package com.dlithe.gkveducation.repository;

import com.dlithe.gkveducation.entity.GkvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GkvDAO extends JpaRepository<GkvEntity, Integer> {

    @Query(value = "SELECT * FROM gkv_table" , nativeQuery = true)
    List<GkvEntity> getGkvClassList();

    @Query(value = "SELECT * FROM gkv_table WHERE gkv_class_number=?1" , nativeQuery = true)
    List<GkvEntity> getGkvStudentList(int gkvClassNumber);

    @Query(value = "SELECT * FROM gkv_table WHERE gkv_student_roll_number=?1" , nativeQuery = true)
    Optional<GkvEntity> getGkvStudentDetailsRollNumber(String gkvStudentRollNumber);

    @Query(value = "SELECT * FROM gkv_table WHERE gkv_student_roll_number=?1" , nativeQuery = true)
    GkvEntity updateGkvStudentDetails(String gkvStudentRollNumber);

}
