package com.bachat.central.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name = "seller")
public class Seller implements Serializable{
    @Id
    @Column(name = "seller_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seller_id=0;

    //only those values will be permitted that are present
    //in user_id column of user table
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name ="property",value = "user"))
    @Column(name ="user_id",nullable = false,unique = true)
    @GeneratedValue(generator = "generator")
    private long user_id;

    //Relationship
    //One-to-one and bidirectional with user table
    @OneToOne (fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private User user;

    //One-To-Many Relationship with shop
    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "seller")
    private Set<Shop>shops = new HashSet<Shop>(0);

    public Seller(){}

    public long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(long seller_id) {
        this.seller_id = seller_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
