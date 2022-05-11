package com.dlithe.gkveducation.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="student_details")
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "student_details_id")
    private int  studentDetailsId;

    @Column(name = "student_name")
    private String  studentName;

    @Column(name = "student_surname")
    private String  studentSurname;

    @Column(name = "student_father_name")
    private String studentFatherName;

    @Column(name = "student_mother_name")
    private String studentMotherName;

    @Column(name = "student_Address")
    private String studentAddress;

    @Column(name = "student_phone_Number")
    private String studentPhoneNumber;

    @Column(name = "student_roll_number")
    private int studentRollNumber;

//    @Column(name="school_standard_id")
//    private int schoolStandardId;



//    @Column(name = "standard_id")
//    private String standardId;



    /* @Column(name = "standard_detail_id")
    private int standardDetailId;   */
}
