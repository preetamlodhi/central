package com.bachat.central.controller;

import com.bachat.central.common.RestMappingConstants;
import com.bachat.central.dao.Category;
import com.bachat.central.dao.Seller;
import com.bachat.central.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

	@RequestMapping(value= RestMappingConstants.GET_SELLER, method = RequestMethod.GET)
	public @ResponseBody
    Seller getSeller(@PathVariable Long id) {
        Seller seller = sellerService.getSeller(id);
        return seller;
	}
    @RequestMapping (value = RestMappingConstants.GET_ALL_SELLER, method = RequestMethod.GET)
    public @ResponseBody
    List <Seller> getAllSeller(){
        List<Seller> sellers = sellerService.getAllSellers();
        return sellers;
    }
    @RequestMapping (value = RestMappingConstants.DELETE_SELLER, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteSeller(@PathVariable Long id){
        sellerService.deleteSeller(id);
        return;
    }

}