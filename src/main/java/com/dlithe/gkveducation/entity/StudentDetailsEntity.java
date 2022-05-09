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
public class StudentDetailsEntity {

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

    @Column(name = "student_class_name")
    private String studentClassName;

    @Column(name = "student_section")
    private String studentSection;

    @Column(name = "student_date")
    private String studentDate;

    @Column(name = "student_email")
    private String studentEmail;

    @Column(name = "student_performance")
    private String studentPerformance;

    @Column(name = "student_pincode")
    private String studentPincode;



    @ManyToOne
    @JoinColumn(name="school_standard_id")
    private SchoolStandardEntity schoolStandardEntity;
//    @Column(name = "standard_id")
//    private String standardId;



    /* @Column(name = "standard_detail_id")
    private int standardDetailId;   */
}
