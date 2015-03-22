package com.bachat.central.service;

import com.bachat.central.common.HibernateHelper;
import com.bachat.central.dao.Seller;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by karan on 8/3/15.
 */
public class SellerService {

    public Seller getSeller(long id){
        Session session = HibernateHelper.getSession();
        Seller seller = (Seller)session.load(Seller.class,id);
        //System.out.println(seller.getEmailAddress() + "  " + seller.getFirstName() + "  " + seller.getId());
        return  seller;
    }
    public List <Seller> getAllSellers(){
        Session session = HibernateHelper.getSession();
        Criteria criteria = session.createCriteria(Seller.class);
        List <Seller> sellers = criteria.list();
        System.out.print("Returning list of all the sellers \n");
        return  sellers;
    }
    public void deleteSeller(long id){
        Session session =HibernateHelper.getSession();
        session.beginTransaction();
        Seller seller = (Seller)session.get(Seller.class,id);
        //System.out.print("deleting seller : "+seller.getFirstName()+" "+seller.getLastName()+" "+seller.getEmailAddress());
        session.delete(seller);
        session.getTransaction().commit();
        return;
    }


}
