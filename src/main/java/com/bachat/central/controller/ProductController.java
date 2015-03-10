package com.bachat.central.controller;

import com.bachat.central.common.RestMappingConstants;
import com.bachat.central.dao.Product;
import com.bachat.central.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by preetam on 9/3/15.
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping (value = RestMappingConstants.GET_PRODUCT, method = RequestMethod.GET)
    public @ResponseBody
    Product getProduct(@PathVariable Long id){
        Product product = productService.getProduct(id);
        return product;
    }
}
