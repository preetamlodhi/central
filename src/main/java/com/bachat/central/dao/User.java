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
    @Column(name="user_id", nullable = false, unique =true)
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
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile=null;

    //One-to-one and bidirectional with seller
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private Seller seller=null;

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

    //equals , hashcode and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (user_id != user.user_id) return false;
        if (contact_number != null ? !contact_number.equals(user.contact_number) : user.contact_number != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (userProfile != null ? !userProfile.equals(user.userProfile) : user.userProfile != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (user_id ^ (user_id >>> 32));
        result = 31 * result + (contact_number != null ? contact_number.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userProfile != null ? userProfile.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", contact_number='" + contact_number + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userProfile=" + userProfile +
                '}';
    }
}
