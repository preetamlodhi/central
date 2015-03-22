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
    @Column(name = "state_id", nullable = false, unique = true)
    private long state_id = 0;

    @Basic
    @Column(name = "name", nullable = false, unique = true, length = 30)
    private String name = null;

    //Relationship one-to-many with city table
    //Bidirectional
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private Set<City> cities = new HashSet<City>(0);

    //Relationship ont-to-many with address table
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private Set<Address> addresses = new HashSet<Address>(0);


}
