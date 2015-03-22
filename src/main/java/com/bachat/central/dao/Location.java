package com.bachat.central.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name = "location" )
public class Location implements Serializable{

    //Composite primary key
    //Coordinate object consist if latitude and longitude
    @Id
    private LocationPK locationPK = null;
}
