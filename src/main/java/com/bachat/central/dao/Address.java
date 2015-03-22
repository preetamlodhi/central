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
    @Column(name = "address_id", nullable = false, unique = true)
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
    @Column(name = "pincode", length = 10)
    private String pincode = null;
}
