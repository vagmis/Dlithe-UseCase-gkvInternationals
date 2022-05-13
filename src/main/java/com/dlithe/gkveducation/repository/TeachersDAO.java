package com.dlithe.gkveducation.repository;

import com.dlithe.gkveducation.entity.GkvEntity;
import com.dlithe.gkveducation.entity.TeachersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersDAO extends JpaRepository<TeachersEntity, Integer> {

    @Query(value = "SELECT * FROM teacher_data" , nativeQuery = true)
    List<TeachersEntity> getTeacherList();
}
