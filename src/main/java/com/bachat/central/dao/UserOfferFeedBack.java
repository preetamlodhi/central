package com.bachat.central.dao;

import javax.persistence.*;

/**
 * Created by preetam on 22/3/15.
 */
@Entity
@Table(name = "user_offer_feedback")
public class UserOfferFeedBack {

    @Id
    private UserOfferFeedBackPK userOfferFeedBackPK = null;

    @Basic
    @Column(name = "status",nullable = false)
    private Boolean status = false;                /////   ( 1/0 )=(like/dislike)

}
