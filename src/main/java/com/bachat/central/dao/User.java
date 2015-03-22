package com.bachat.central.dao;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by preetam on 21/3/15.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id=0;

    @Basic
    @Column(name= "contact_number", nullable = false, unique = true, length = 14)
    private String contact_number=null;

    @Basic
    @Column(name = "email", unique = true, length = 30)
    private String email=null;

    @Basic
    @Column(name ="password", nullable = false, length = 30)      ///SHA
    private String password=null;

    //Relationship
    //One-to-one and bidirectional with user_profile table
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;

    //Relationship
    //One-to-one and bidirectional with seller table
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "user", cascade = CascadeType.ALL)
    private Seller seller;


    public User(){}
    //One-to-one and bidirectional with seller
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "seller_id")
    //private Seller seller=null;

    //One-to-many relationship with OfferHistory
    //private Set<OfferHistory>offerHistories = new HashSet<OfferHistory>(0);


    //Getter and setter methods

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
