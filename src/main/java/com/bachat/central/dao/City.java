package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name = "city")
public class City implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private long city_id = 0;

    @Basic
    @Column(name = "name", nullable = false)
    private String name = null;

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    //Relationship one-to-many with Address table
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "city_id")
    //private Set<Address> addresses = new HashSet<Address>(0);


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id",nullable = false)
    private State state;

}
