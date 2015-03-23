package com.bachat.central.dao;

import javax.persistence.*;
import javax.xml.parsers.FactoryConfigurationError;
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
    @Column(name = "category_id")
    private long category_id = 0;

    @Basic
    @Column(name = "name", nullable = false, unique = true,length = 30)
    private String name = null;


    //MANY-TO-MANY relationship with shop
    //Bidirectional

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private Set<Shop>shops = new HashSet<Shop>(0);

    //one-to-many relationship with offer
    //Bidirectional
    //private Set<Offer>offers = new HashSet<Offer>(0);

    public Category(){}

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }
}
