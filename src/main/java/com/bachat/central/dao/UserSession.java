package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by preetam on 22/3/15.
 */

@Entity
@Table(name = "user_session")
public class UserSession implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_session_id", nullable = false, unique = true)
    private long user_session_id = 0;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleType role=null;
}
