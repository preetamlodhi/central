package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name = "address")
public class Address implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private long address_id = 0;

    @Basic
    @Column(name = "line1", nullable = false, length = 30)
    private String line1 =  null;

    @Basic
    @Column(name = "line2", length = 30)
    private String line2 = null;

    @Basic
    @Column(name = "area", length = 30)
    private String area = null;

    @Basic
    @Column(name = "pincode", length = 6)
    private String pincode = null;

    //Many to one relationship with City
    //Bidirectional
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id",nullable = false)
    private City city;

    //Relationship with State
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
