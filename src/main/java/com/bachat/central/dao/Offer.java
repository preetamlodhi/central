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
    @Column(name = "start_date", nullable = false)
    private Calendar start_date = null;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    private Calendar end_date = null;

    @Basic
    @Temporal(TemporalType.TIME)
    @Column(name = "start_time", nullable = false)
    private Date startTime = null;                 //proper matching?

    @Basic
    @Temporal(TemporalType.TIME)
    @Column(name = "end_time", nullable = false)
    private Date end_time = null;                  //proper matching?

    @Basic
    @Column(name = "description", nullable = false, length = 50)     //maximum 50 characters for description
    private String description = null;

    @Basic
    @Column(name = "is_active",nullable = false)
    private Boolean is_active = false;

    @Basic
    @Column(name = "likes")
    long likes = 0;

    @Basic
    @Column(name = "dislikes")
    long dislikes = 0;

    //many-to-one relationship with shop
    //bidirectional

    //one-to-many relationship with offer_history
    //private Set<OfferHistory>offerHistories = new HashSet<OfferHistory>(0);
}
