package com.bachat.central.service;

import com.bachat.central.common.HibernateHelper;
import com.bachat.central.dao.Product;
import org.hibernate.Session;

/**
 * Created by preetam on 9/3/15.
 */
public class ProductService{

    public Product getProduct(long id){
        Session session = HibernateHelper.getSession();
        Product product = (Product) session.load(Product.class,id);
        return product;
    }
}
