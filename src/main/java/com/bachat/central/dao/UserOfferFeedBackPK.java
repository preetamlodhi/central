package com.bachat.central.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by preetam on 22/3/15.
 */

//Compsite primary key for UserOfferFeedBack table
@Embeddable
public class UserOfferFeedBackPK implements Serializable{

    @Column(name = "user_id",nullable = false)
    private long user_id = 0;
    @Column(name = "offer_id", nullable = false)
    private long offer_id = 0;

    public UserOfferFeedBackPK(){}

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(long offer_id) {
        this.offer_id = offer_id;
    }
}
