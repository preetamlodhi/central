package com.bachat.central.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by preetam on 22/3/15.
 */
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable{
    @Id
    private UserRolePK userRolePK;

    public UserRole(){}

    public UserRolePK getUserRolePK() {
        return userRolePK;
    }

    public void setUserRolePK(UserRolePK userRolePK) {
        this.userRolePK = userRolePK;
    }
}
