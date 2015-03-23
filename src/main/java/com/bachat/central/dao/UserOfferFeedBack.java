package com.bachat.central.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by preetam on 22/3/15.
 */
@Entity
@Table(name = "user_offer_feedback")
public class UserOfferFeedBack implements Serializable{

    @EmbeddedId
    private UserOfferFeedBackPK userOfferFeedBackPK = null;

    @Basic
    @Column(name = "status")
    private Boolean status = null;                /////   ( 1/0 )=(like/dislike)

    public UserOfferFeedBack(){}

    public UserOfferFeedBackPK getUserOfferFeedBackPK() {
        return userOfferFeedBackPK;
    }

    public void setUserOfferFeedBackPK(UserOfferFeedBackPK userOfferFeedBackPK) {
        this.userOfferFeedBackPK = userOfferFeedBackPK;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
