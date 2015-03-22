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
    @Column(name = "offer_history_id")
    private long offer_history_id = 0;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Event type = null;

    @Basic
    @Column(name = "description", length = 50)
    private String description = null;


    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")
    private Calendar timestamp = null;

    //many-to-one relationship with offer

    //many-to-one relationship with user

}
