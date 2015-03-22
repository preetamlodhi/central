package com.bachat.central.dao;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by preetam on 21/3/15.
 */

//This is composite primary key to be used by Location table
@Embeddable
public class LocationPK implements Serializable{
    private Double latitude = 0.0;
    private Double longitude = 0.0;

    public LocationPK(){}

}
