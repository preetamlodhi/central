package com.bachat.central.service;

import com.bachat.central.dao.Seller;

/**
 * Created by karan on 8/3/15.
 */
public class SellerService {

    public Seller getSeller(long id){
        Seller seller = new Seller();
        seller.setId(id);
        return seller;
    }
}
