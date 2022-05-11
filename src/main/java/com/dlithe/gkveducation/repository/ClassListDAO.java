package com.dlithe.gkveducation.repository;

import com.dlithe.gkveducation.entity.ClassListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassListDAO extends JpaRepository<ClassListEntity, Integer> {

    @Query(value = "SELECT * FROM class_list_name;" , nativeQuery = true)
    List<ClassListEntity> getAllClassList();

}
