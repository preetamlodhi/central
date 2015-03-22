package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by preetam on 22/3/15.
 */

@Entity
@Table(name = "category")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", nullable = false, unique = true)
    private long category_id = 0;

    @Basic
    @Column(name = "name", nullable = false, unique = true)
    private String name = null;


    //one-to-many relationship with shop
    //Bidirectional
    //private Set<Shop>shops = new HashSet<Shop>(0);

    //one-to-many relationship with offer
    //Bidirectional
    //private Set<Offer>offers = new HashSet<Offer>(0);
}
