package com.bachat.central.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by preetam on 22/3/15.
 */
public class Main{
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
    ///////////////////////////////////////////////////////
    //Utility functions
    public static void addAddress(String line1, String line2,String area,String pincode,long city_id,long state_id){

        Session session = getSession();
        session.beginTransaction();
        Address address = new Address();
        address.setLine1(line1);
        address.setLine2(line2);
        address.setArea(area);
        address.setPincode(pincode);
        address.setCity((City) session.get(City.class, city_id));
        address.setState((State) session.get(State.class, state_id));
        session.save(address);
        session.getTransaction().commit();
    }
    public static void addUser(String contact_number, String email, String password){
        Session session = getSession();
        session.beginTransaction();
        User user = new User();
        user.setContact_number(contact_number);
        user.setEmail(email);
        user.setPassword(password);
        session.save(user);
        session.getTransaction().commit();
    }
    public static void addUserProfile(long user_id,Date date_of_birth,String firstName, Gender gender, String lastName ){

        Session session = getSession();
        session.beginTransaction();
        UserProfile userProfile = new UserProfile();
        User user = (User) session.load(User.class,user_id);
        userProfile.setDate_of_birth(date_of_birth);
        userProfile.setFirstName(firstName);
        userProfile.setGender(gender);
        userProfile.setLastName(lastName);

        user.setUserProfile(userProfile);
        userProfile.setUser(user);
        session.save(user);
        session.getTransaction().commit();


    }
    public static void addSeller(long user_id){

        Session session = getSession();
        session.beginTransaction();
        Seller seller = new Seller();
        User user = (User)session.load(User.class,user_id);
        seller.setUser_id(user_id);
        session.save(seller);
        session.getTransaction().commit();

    }
    ///////////////////////////////////////////////////////

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        System.out.println("Hello !!");

        //addAddress("NSB college","NSB Road","Outer circle","470999",2,1);
        //printAddressesOfCity(2);
        //printAddressesOfState(1);

        //addUser("9988776655","dummy@xyz.com","**11aaBB");
        //addUser("8822009977","dummydummy@abc.com","33**hhNN");

        //addUserProfile(1L,new Date(),"Dinesh",Gender.MALE,"Karthik");
        //addUserProfile(2L,new Date(),"Menka",Gender.FEMALE,"Gandhi");

        //addUserProfile(3L,new Date(),"Menka",Gender.FEMALE,"Gandhi"); //This will give error.
                                                                        //trying to insert duplicate profile for same user.
        //addUser("4400882200","dummy3@bmw.com","88yyTT..");

        //---------- MAKING seller Table--------//
        //addSeller(2L);
        System.out.println("Bye Bye !!");

    }
}
