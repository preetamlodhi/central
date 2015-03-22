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
    @Column(name = "city_id", nullable = false, unique = true)
    private long city_id = 0;

    @Basic
    @Column(name = "name", nullable = false)
    private String name = null;

    //Relationship one-to-many with Address table
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private Set<Address> addresses = new HashSet<Address>(0);


}
