package com.bachat.central.controller;

import com.bachat.central.dao.Category;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offer")
public class OfferController {
    private static int i=1;
	@RequestMapping(value="{name}" , method = RequestMethod.GET)
	public @ResponseBody Category printWelcome(@PathVariable String name) {
        Category category = new Category();
        category.setName(name);
        category.setId(i);
        return  category;
	}
}