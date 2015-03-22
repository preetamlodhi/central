package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable{
    @Id
    @Column(name ="user_profile_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_profile_id=0;

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
    @Column(name = "gender")
    private Gender gender;

    //Relationship
    //One-to-one and bidirectional with user table
    //@OneToOne (mappedBy = "user")
    //private User user=null;
}
