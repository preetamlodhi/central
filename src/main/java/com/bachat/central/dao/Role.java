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
    @Column(name = "name")
    private RoleType name = null;

}
