package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by preetam on 22/3/15.
 */
@Entity
@Table(name = "shop_rating")
public class ShopRating implements Serializable{

    @Id
    private ShopRatingPK shopRatingPK = null;

    @Basic
    @Column(name = "rating") //////////////////make it decimal to range from 1 to 5 with step size of .5
    private Double rating=0.0;

}
