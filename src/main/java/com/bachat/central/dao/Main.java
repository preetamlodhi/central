package com.bachat.central.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.text.SimpleDateFormat;
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
    public static void addUserProfile(long user_id,Date date_of_birth,String firstName,
                                      Gender gender, String lastName ){
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
    //in seller table,
    //Address, Location
    //currently opening_time , closing_time and offday is set to default
    //later it will be changed.
    public static void addShop(String shop_name, long[]categories_array,long seller_id,
                               String line1, String line2,String area,String pincode,
                               long city_id,long state_id,Double latitude, Double longitude){
        Session session = getSession();
        session.beginTransaction();
        //Create an address object
        Address address = new Address();
        address.setLine1(line1);
        address.setLine2(line2);
        address.setArea(area);
        address.setPincode(pincode);
        address.setCity((City) session.get(City.class, city_id));
        address.setState((State) session.get(State.class, state_id));

        //Create an location object.
        Location location = new Location();
        location.setLatitude(latitude);
        location.setLongitude(longitude);

        //Create shop object.
        Shop shop = new Shop();
        shop.setName(shop_name);

        shop.setSeller((Seller)session.get(Seller.class,seller_id));
        shop.setExternal_shop_id(seller_id*500);         //////Here proper method has to be set.
        //adding all categoris
        for(long category_id:categories_array){
            shop.getCategories().add((Category)session.load(Category.class,category_id));
        }

        //Link it with address
        address.setShop(shop);
        shop.setAddress(address);

        //Link it with location
        location.setShop(shop);
        shop.setLocation(location);



        session.save(shop);
        session.getTransaction().commit();
    }


    //Adding a offer
    public static void addOffer(long shop_id, long category_id, String description){
        Session session = getSession();
        session.beginTransaction();
        Offer offer = new Offer();
        offer.setShop((Shop)session.get(Shop.class,shop_id));
        offer.setCategory((Category) session.get(Category.class, category_id));
        offer.setDescription(description);
        session.save(offer);
        session.getTransaction().commit();
    }

    public static void addShopRating(long user_id, long shop_id, double rating){
        Session session = getSession();
        session.beginTransaction();
        ShopRatingPK shopRatingPK = new ShopRatingPK();
        shopRatingPK.setUser_id(user_id);
        shopRatingPK.setShop_id(shop_id);
        ShopRating shopRating = new ShopRating();
        shopRating.setShopRatingPK(shopRatingPK);
        shopRating.setRating(rating);
        session.save(shopRating);
        session.getTransaction().commit();
    }

    public static void updateShopRating(long user_id, long shop_id, double new_rating){
        Session session = getSession();
        session.beginTransaction();
        ShopRatingPK shopRatingPK = new ShopRatingPK();
        shopRatingPK.setUser_id(user_id);
        shopRatingPK.setShop_id(shop_id);

        ShopRating shopRating =(ShopRating)session.get(ShopRating.class,shopRatingPK);
        shopRating.setRating(new_rating);

        session.save(shopRating);
        session.getTransaction().commit();
    }

    public static void addUserOfferFeedback(long user_id, long offer_id,Boolean status){
        Session session = getSession();
        session.beginTransaction();
        UserOfferFeedBackPK userOfferFeedBackPK = new UserOfferFeedBackPK();
        userOfferFeedBackPK.setUser_id(user_id);
        userOfferFeedBackPK.setOffer_id(offer_id);
        UserOfferFeedBack userOfferFeedBack = new UserOfferFeedBack();
        userOfferFeedBack.setUserOfferFeedBackPK(userOfferFeedBackPK);
        userOfferFeedBack.setStatus(status);
        session.save(userOfferFeedBack);
        session.getTransaction().commit();
    }

    public static void updateUserOfferFeedback(long user_id, long offer_id, Boolean new_status){
        Session session = getSession();
        session.beginTransaction();
        UserOfferFeedBackPK userOfferFeedBackPK= new UserOfferFeedBackPK();
        userOfferFeedBackPK.setUser_id(user_id);
        userOfferFeedBackPK.setOffer_id(offer_id);

        UserOfferFeedBack userOfferFeedBack =
                (UserOfferFeedBack)session.get(UserOfferFeedBack.class,userOfferFeedBackPK);
        userOfferFeedBack.setStatus(new_status);
        session.save(userOfferFeedBack);
        session.getTransaction().commit();

    }

    public static void addOfferHistory(String event_description, Event event_type, long user_id, long offer_id){
        Session session = getSession();
        session.beginTransaction();
        OfferHistory offerHistory = new OfferHistory();
        offerHistory.setEvent_description(event_description);
        offerHistory.setEvent_type(event_type);
        //set timestamp
        offerHistory.setUser((User)session.get(User.class,user_id));
        offerHistory.setOffer((Offer)session.get(Offer.class,offer_id));
        session.save(offerHistory);
        session.getTransaction().commit();

    }

    ///////////////////////////////////////////////////////

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        System.out.println("Hello !!");

        //addUser("9988776655","dummy@xyz.com","**11aaBB");
        //addUser("8822009977","dummydummy@abc.com","33**hhNN");

        //addUserProfile(1L,new Date(),"Dinesh",Gender.MALE,"Karthik");
        //addUserProfile(2L,new Date(),"Menka",Gender.FEMALE,"Gandhi");

        //addUserProfile(3L,new Date(),"Menka",Gender.FEMALE,"Gandhi"); //This will give error.
                                                                        //trying to insert duplicate profile for same user.
        //addUser("4400882200","dummy3@bmw.com","88yyTT..");

        //---------- MAKING seller Table---------------//
        //addSeller(1L);
        //addSeller(2L);

        //----------MAKING role table---------------------//
        //addRole(RoleType.ADMIN);

        //---------MAKING user_role table------------------//
        //addUserRole(3L,2L);

        //---------MAKING category table-----------------------//
        //addCategory("Clothing");
        //addCategory("Medicine");
        //addCategory("Fruits");
        //addCategory("Vegetable");
        //addCategory("Food");

        //--------MAKING shop table----------------------------//
        //long[] categories_array = {2, 3};
        //addShop("Pappu kirana stores",categories_array,1L,
        //"Near Raj motors", "GT Road","Palasiya","900200",
        //6L,1L,100.67, 200.88);

        //------MAKING offer table-----------------------------//
        //addOffer(1L,4L,"Buy one get one free");
        //addOffer(4L,2L,"50% off on Tea");
        //addOffer(2L,1L,"40% off on Samosa");
        //addOffer(2L,5L,"Buy 3 get 1 FREE");

        //------MAKING shop_rating-----------------------------//
        //addShopRating(1L,2L,4.5);
        //addShopRating(3L,1L,4.5);
        //updateShopRating(3L,1L,2.5);

        //----MAKING user_offer_feedback-----------------------//
        //addUserOfferFeedback(1L,2L,true);
        //addUserOfferFeedback(3L,1L,true);
        //updateUserOfferFeedback(1L,2L,false);

        //----MAKING offer_history------------------------------//
        //addOfferHistory("new offer inserted",Event.INSERT,1L,2L);
        //addOfferHistory("offer updated",Event.UPDATE,1L,2L);
        //addOfferHistory("again updated",Event.UPDATE,1L,2L);
        //addOfferHistory("offer deleted",Event.DELETE,1L,2L);
        System.out.println("Bye Bye !!");

    }
}
