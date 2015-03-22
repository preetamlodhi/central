package com.bachat.central.dao;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by preetam on 22/3/15.
 */

//Compsite primary key for UserOfferFeedBack table
@Embeddable
public class UserOfferFeedBackPK implements Serializable{

    private long user_id = 0;
    private long offer_id = 0;

    public UserOfferFeedBackPK(){}
}
