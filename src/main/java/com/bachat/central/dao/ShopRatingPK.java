package com.bachat.central.dao;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by preetam on 22/3/15.
 */

//Composite primary key for ShopRating table
@Embeddable
public class ShopRatingPK implements Serializable{

    private long user_id = 0;
    private long shop_id = 0;

    public ShopRatingPK(){}
}
