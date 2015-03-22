package com.bachat.central.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by preetam on 22/3/15.
 */

//Primary key for UserRole
@Embeddable
public class UserRolePK implements Serializable{

    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name ="property",value = "user"))
    @Column(name ="user_id",nullable = false)
    @GeneratedValue(generator = "generator")
    private long user_id=0;

    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name ="property",value = "role"))
    @Column(name ="role_id",nullable = false)
    @GeneratedValue(generator = "generator")
    private long role_id=0;

    public UserRolePK() {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }
}
