package com.huajicar.demo.controller;

import com.huajicar.demo.service.AgentService;
import com.huajicar.demo.service.CarService;
import com.huajicar.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {
    @Autowired
    private CarService carService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private CommentService commentService;

    @GetMapping(value = {"/","/index"})
    String index(Model model, HttpSession httpSession){
        model.addAttribute("brands",carService.getCarProperty("car_brand"));
        model.addAttribute("types",carService.getCarProperty("car_type"));
        model.addAttribute("ages",carService.getCarProperty("car_age"));
        model.addAttribute("shifts",carService.getCarProperty("car_shift"));
        model.addAttribute("colors",carService.getCarProperty("car_color"));
        model.addAttribute("fuels",carService.getCarProperty("car_fuel"));
        model.addAttribute("agents",agentService.getAgentByNum(4));
        model.addAttribute("cars_slider",carService.getNRandomCar(4));
        model.addAttribute("cars",carService.getNRandomCar(6));
        model.addAttribute("comments",commentService.getNRandomCar(3));
        return "index";
    }
}
