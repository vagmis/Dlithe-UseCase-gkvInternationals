package com.dlithe.gkveducation.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="gkv_table")
public class GkvEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "gkv_student_id")
    private int  gkvStudentId;

    @Column(name = "gkv_standard_name")
    private String  gkvStandardName;

    @Column(name = "gkv_standard_photo")
    private String gkvStandardPhoto;

    @Column(name = "gkv_standard_tagline")
    private String gkvStandardTagLine;

    @Column(name = "gkv_class_number")
    private int gkvClassNumber;

    @Column(name = "gkv_student_name")
    private String  gkvStudentName;

    @Column(name = "gkv_student_surname")
    private String  gkvStudentSurname;

    @Column(name = "gkv_student_father_name")
    private String gkvStudentFatherName;

    @Column(name = "gkv_student_mother_name")
    private String gkvStudentMotherName;

    @Column(name = "gkv_student_Address")
    private String gkvStudentAddress;

    @Column(name = "gkv_student_phone_number")
    private String gkvStudentPhoneNumber;

    @Column(name = "gkv_student_roll_number")
    private String gkvStudentRollNumber;


}
