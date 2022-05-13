package com.dlithe.gkveducation.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="admin_login")
public class AdminLoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "admin_login_id")
    private int adminLoginId;

    @Column(name = "admin_login_name")
    private String  adminLoginName;

    @Column(name = "admin_login_password")
    private String adminLoginPassword;

    @Column(name = "admin_photo")
    private String adminPhoto;

    @Column(name = "admin_designation")
    private String adminDesignation;

}
