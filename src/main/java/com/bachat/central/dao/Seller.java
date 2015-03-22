package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name = "seller")
public class Seller implements Serializable{
    @Id
    @Column(name = "seller_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seller_id=0;

    //Relationship
    //One-to-one and bidirectional with user table
    @OneToOne (mappedBy = "seller")
    private User user=null;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private Set<Shop>shops = new HashSet<Shop>(0);

}
