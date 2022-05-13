package com.dlithe.gkveducation.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="teacher_data")
public class TeachersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "teacher_name")
    private String  teacherName;

    @Column(name = "teacher_photo")
    private String teacherPhoto;

    @Column(name = "teacher_description")
    private String teacherDescription;


}
