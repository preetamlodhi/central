package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by preetam on 22/3/15.
 */
@Entity
@Table(name = "shop")
public class Shop implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id", nullable = false, unique = true)
    private long shop_id;

    @Basic
    @GeneratedValue(strategy = GenerationType.AUTO)                    //////This should be generated properly
    @Column(name = "external_shop_id", nullable = false, unique = true)
    private long external_shop_id;

    //one-to-one relationship with address table
    //Bidirectional
    //@OneToOne(mappedBy = "address")
    //private Address address = null;

    //one-to-one relationship with location table
    //Bidirectional
   // @OneToOne(mappedBy = "location")
   // private Location location = null;

    //one-to-many relationship with offer table
    //bidirectional
    //private Set<Offer>offers = new HashSet<Offer>(0);

    //many-to-one relationship with category table
    //Bidirectional

}
