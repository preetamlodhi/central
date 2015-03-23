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

    //Adds a user to the user table
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

    //Accepts only those user_id that are present in user table
    //A single user can be assigned only with a single user_profile
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

    //Accepts only those user_id that are present in user table.
    //Multiple sellers can't be associated with a single user.
    public static void addSeller(long user_id){
        Session session = getSession();
        session.beginTransaction();
        Seller seller = new Seller();
        User user = (User)session.load(User.class,user_id);
        seller.setUser_id(user_id);
        session.save(seller);
        session.getTransaction().commit();
    }

    //Accepts values that are present in RolyType Enum
    public static void addRole(RoleType roleType){
        Session session = getSession();
        session.beginTransaction();
        Role role = new Role();
        role.setName(roleType);
        session.save(role);
        session.getTransaction().commit();
    }

    //Accepts  user_id's that are  present in user table and role_id's that
    //  are present in role table
    public static void addUserRole(long user_id, long role_id){
        Session session = getSession();
        session.beginTransaction();
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setUser_id(user_id);
        userRolePK.setRole_id(role_id);
        UserRole userRole = new UserRole();
        userRole.setUserRolePK(userRolePK);
        session.save(userRole);
        session.getTransaction().commit();
    }

    //Adds a new category to category table
    public static void addCategory(String category_name){
        Session session = getSession();
        session.beginTransaction();
        Category category = new Category();
        category.setName(category_name);
        session.save(category);
        session.getTransaction().commit();
    }

    //Adding a shop
    //Accepts shop name, categories present in category table, seller_id present
    //in seller table.
    public static void addShop(String shop_name, long[]categories_array,long seller_id){
        Session session = getSession();
        session.beginTransaction();
        Shop shop = new Shop();
        shop.setName(shop_name);
        shop.setSeller((Seller)session.get(Seller.class,seller_id));
        shop.setExternal_shop_id(seller_id*100);                      //////Here proper method has to be set.


        //adding all categoris
        for(long category_id:categories_array){
            shop.getCategories().add((Category)session.load(Category.class,category_id));
        }

        session.save(shop);
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
        //addSeller(1L);
        //addSeller(2L);

        //----------MAKING role table------------//
        //addRole(RoleType.ADMIN);


        //---------MAKING user_role table-----------//
        //addUserRole(3L,2L);

        //---------MAKING category table--------------//
        //addCategory("Clothing");
        //addCategory("Medicine");
        //addCategory("Fruits");
        //addCategory("Vegetable");
        //addCategory("Food");

        //--------MAKING shop table---------------//
        //long[] categories_array = {1, 2, 3};
        //addShop("Panjab Handloom",categories_array,2);
        //long[] categories_array2={1};
        //addShop("Jhabra paradise",categories_array2,1);

        long[] categories_array = {4,5};
        //addShop("Jaykedaar",categories_array,3);
        addShop("Jaykedaar",categories_array,2);
        System.out.println("Bye Bye !!");

    }
}
