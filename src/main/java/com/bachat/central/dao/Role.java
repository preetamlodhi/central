package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name ="role")
public class Role implements Serializable{

    @Id
    @Column(name ="role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "name",nullable = false, length = 20,unique = true)
    private RoleType name = null;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }
}
