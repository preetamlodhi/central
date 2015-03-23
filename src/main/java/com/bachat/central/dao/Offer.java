package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by preetam on 22/3/15.
 */

@Entity
@Table(name = "offer")
public class Offer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "offer_id", nullable = false, unique = true)
    private long offer_id = 0;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")                //set nullabe = false  proper matching ? //
    private Calendar start_date=null;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")                  //set nullabe = false  proper matching ? //
    private Calendar end_date=null;

    @Basic
    @Temporal(TemporalType.TIME)
    @Column(name = "start_time")                //set nullabe = false  proper matching ? //
    private Date startTime=null;

    @Basic
    @Temporal(TemporalType.TIME)
    @Column(name = "end_time")                  //set nullabe = false  proper matching ? //
    private Date end_time=null;

    @Basic
    @Column(name = "description", nullable = false, length = 100)     //maximum 50 characters for description
    private String description =null;

    @Basic
    @Column(name = "is_active",nullable = false)
    private Boolean is_active=false;

    @Basic
    @Column(name = "likes",nullable = false)
    long likes=0;

    @Basic
    @Column(name = "dislikes",nullable = false)
    long dislikes=0;

    //Many to one relationship with Shop
    //Bidirectional
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id",nullable = false)
    private Shop shop;

    //Many to one relationship with Category
    //Bidirectional
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    //one-to-many relationship with offer_history
    //private Set<OfferHistory>offerHistories = new HashSet<OfferHistory>(0);
    public Offer(){}

    public long getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(long offer_id) {
        this.offer_id = offer_id;
    }

    public Calendar getStart_date() {
        return start_date;
    }

    public void setStart_date(Calendar start_date) {
        this.start_date = start_date;
    }

    public Calendar getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Calendar end_date) {
        this.end_date = end_date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
