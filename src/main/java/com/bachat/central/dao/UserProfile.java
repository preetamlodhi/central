package com.bachat.central.dao;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable{
    @GenericGenerator(name = "generator", strategy = "foreign",
    parameters = @org.hibernate.annotations.Parameter(name ="property", value = "user"))
    @Id
    @Column(name ="user_id")
    @GeneratedValue(generator = "generator")
    private long user_id=0;

    @Basic
    @Column(name = "firstName", nullable = false, length = 25)
    private String firstName;

    @Basic
    @Column(name = "lastName", nullable = false, length = 25)
    private String lastName;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth" )
    private Date date_of_birth;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length =20)
    private Gender gender;

    //Relationship
    //One-to-one and bidirectional with user table
    @OneToOne (fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private User user;

    public UserProfile(){}

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
