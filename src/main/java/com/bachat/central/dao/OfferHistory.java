package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by preetam on 22/3/15.
 */
@Entity
@Table(name = "offer_history")
public class OfferHistory implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private long event_id = 0;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "event_type",nullable = false)
    private Event event_type;

    @Basic
    @Column(name = "event_description", length = 100)
    private String event_description = null;


    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")        //later set it nullable =false
    private Calendar timestamp = null;

    //Many to one relationship with Offer
    //Bidirectional
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offer_id",nullable = false)
    private Offer offer;

    //Many to one relationship with User
    //Bidirectional
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public OfferHistory(){}

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public Event getEvent_type() {
        return event_type;
    }

    public void setEvent_type(Event event_type) {
        this.event_type = event_type;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
