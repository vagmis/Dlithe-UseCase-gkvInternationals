package com.dlithe.gkveducation.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name="class-list-name")
public class ClassListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "school_standard_id")
    private int schoolStandardId;

    @Column(name = "school_standard_name")
    private String  schoolStandardName;

    @Column(name = "school_standard_photo")
    private String schoolStandardPhoto;

    @Column(name = "school_tagline")
    private String schoolStandardTagline;


    @Column(name = "class_number")
    private int classNumber;



}
