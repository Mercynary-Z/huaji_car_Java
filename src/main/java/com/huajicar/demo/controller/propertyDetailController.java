package com.huajicar.demo.controller;

import com.huajicar.demo.entity.Car;
import com.huajicar.demo.entity.Trade;
import com.huajicar.demo.entity.User;
import com.huajicar.demo.service.CarService;
import com.huajicar.demo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class propertyDetailController {
    @Autowired
    private CarService carService;

    @Autowired
    private TradeService tradeService;

    @GetMapping("/PropertyDetail")
    String list(@RequestParam(value = "id") int id, Model model,
                HttpSession httpSession){
        model.addAttribute("car",carService.getCarById(id));
        return "Property-Details";
    }

    @GetMapping("/Purchase")
    String purchase(@RequestParam("id")int id,HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:Login";
        }
        User user=(User)httpSession.getAttribute("user");
        Car car=carService.getCarById(id);
        if(user.getUser_account().equals(car.getUser().getUser_account())||car.getOn_sale()==0){
            return "redirect:/PropertyDetail?id="+id;
        }
        tradeService.purchaseCar(car,user);
        return "Purchased";
    }
}
