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
@Table(name="school_standard_data1")
public class SchoolStandardEntity {

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

//    @OneToMany(mappedBy = "schoolStandardEntity")
//    @Column(name="standard_id")
//    private List<StudentDetailsEntity> studentDetailsEntityList;


}
