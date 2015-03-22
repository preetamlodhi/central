package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name = "state")
public class State implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "state_id")
    private long state_id = 0;

    @Basic
    @Column(name = "name", nullable = false, unique = true, length = 30)
    private String name = null;

    public long getState_id() {
        return state_id;
    }

    public void setState_id(long state_id) {
        this.state_id = state_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

//   Relationship one-to-many with city table
//   Bidirectional
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "state")
    private Set<City> cities = new HashSet<City>(0);

//  Relationship ont-to-many with address table
//  Bidirectional
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "state")
    private Set<Address>addresses = new HashSet<Address>(0);

}
