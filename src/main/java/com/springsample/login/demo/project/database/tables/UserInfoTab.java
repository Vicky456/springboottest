package com.springsample.login.demo.project.database.tables;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "UserInfoTab")

public class UserInfoTab implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long USERID;

    @NotEmpty(message = "Please provide a username")
    @Column(nullable = false,unique = true)
    private String USERNAME;

    @NotEmpty(message = "Please provide a password")
    @Column(nullable = false)
    private String PASSWORD;


    private Date DOB;

    @Column(nullable = false)
    private Date CreatedDate;


    private Date ModifiedDate;

    public UserInfoTab() {
    }


    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }


    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }



    public void setModifiedDate(Date modifiedDate) {
        ModifiedDate = modifiedDate;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Long getUSERID() {
        return USERID;
    }


    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

}
