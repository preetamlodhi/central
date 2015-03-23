package com.bachat.central.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name = "location" )
public class Location implements Serializable{
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name ="property", value = "shop"))
    @Id
    @Column(name ="shop_id")
    @GeneratedValue(generator = "generator")
    private long shop_id=0;

    @Basic
    @Column(name = "latitude", nullable = false)
    private Double latitude = 0.0;

    @Basic
    @Column(name = "longitude", nullable = false)
    private Double longitude = 0.0;

    //Relationship
    //One-to-one and bidirectional with shop table
    @OneToOne (fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Shop shop;

    public Location(){}

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
