package com.bachat.central.dao;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
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

    @Basic
    @Temporal(TemporalType.TIME)
    @Column(name = "opening_time")
    private Date opening_time ;

    @Basic
    @Temporal(TemporalType.TIME)
    @Column(name = "closing_time")
    private Date closing_time;

    @Basic
    @Column(name = "off_day")
    private String off_day=null;

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

    //Relationship
    //One-to-one and bidirectional with address table
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "shop", cascade = CascadeType.ALL)
    private Address address;

    //Relationship
    //One-to-one and bidirectional with location table
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "shop", cascade = CascadeType.ALL)
    private Location location;

    //one-to-many relationship with offer table
    //bidirectional
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "shop")
    private Set<Offer>offers = new HashSet<Offer>(0);

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

    public Date getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(Date opening_time) {
        this.opening_time = opening_time;
    }

    public Date getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(Date closing_time) {
        this.closing_time = closing_time;
    }

    public String getOff_day() {
        return off_day;
    }

    public void setOff_day(String off_day) {
        this.off_day = off_day;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
