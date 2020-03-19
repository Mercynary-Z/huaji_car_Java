package com.huajicar.demo.controller;

import com.huajicar.demo.service.AgentService;
import com.huajicar.demo.service.CarService;
import com.huajicar.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class propertyListingController {
    @Autowired
    private CarService carService;

    @GetMapping("/PropertyListing")
    String list(@RequestParam(value = "car_brand",required = false) String car_brand,@RequestParam(value = "car_type",required = false) String car_type,
                @RequestParam(value = "car_age",required = false) String car_age,@RequestParam(value = "car_shift",required = false) String car_shift,
                @RequestParam(value = "car_color",required = false) String car_color,@RequestParam(value = "car_fuel",required = false) String car_fuel,
                @RequestParam(value = "price_min",required = false) Integer price_min,@RequestParam(value = "price_max",required = false) Integer price_max, Model model,
                HttpSession httpSession){
        model.addAttribute("cars",carService.getCarByCondition(car_brand,car_type,car_age,car_shift,car_color,car_fuel,price_min,price_max));
        return "Property-Listing";
    }
}
