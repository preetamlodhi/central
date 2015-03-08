package com.bachat.central.controller;

import com.bachat.central.common.RestMappingConstants;
import com.bachat.central.dao.Category;
import com.bachat.central.dao.Seller;
import com.bachat.central.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}