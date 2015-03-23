package com.bachat.central.dao;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    //////Here Generation strategy will be customized later
    @Basic
    @Column(name = "external_shop_id", nullable = false, unique = true)
    private long external_shop_id;

    @Basic
    @Column(name = "name", nullable = false,length = 50)
    private String name=null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    //MANY-TO-MANY relationship with category table
    //Bidirectional
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable (name ="shop_category", catalog = "bachat", joinColumns = {
            @JoinColumn(name ="shop_id", nullable = false, updatable = false) },
            inverseJoinColumns = {@JoinColumn(name = "category_id",nullable = false,updatable = false)})
    private Set<Category> categories = new HashSet<Category>(0);

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

    public Shop(){}

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public long getExternal_shop_id() {
        return external_shop_id;
    }

    public void setExternal_shop_id(long external_shop_id) {
        this.external_shop_id = external_shop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
