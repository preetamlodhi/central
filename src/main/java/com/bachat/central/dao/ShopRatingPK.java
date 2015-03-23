package com.bachat.central.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by preetam on 22/3/15.
 */

//Composite primary key for ShopRating table
@Embeddable
public class ShopRatingPK implements Serializable{

    @Column(name ="user_id",nullable = false)
    private long user_id = 0;
    @Column(name = "shop_id",nullable = false)
    private long shop_id = 0;

    public ShopRatingPK(){}

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }
}
