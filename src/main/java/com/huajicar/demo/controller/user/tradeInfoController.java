package com.huajicar.demo.controller.user;

import com.huajicar.demo.entity.Car;
import com.huajicar.demo.entity.CarBought;
import com.huajicar.demo.entity.User;
import com.huajicar.demo.service.CarService;
import com.huajicar.demo.service.ChopService;
import com.huajicar.demo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class tradeInfoController {
    @Autowired
    private TradeService tradeService;

    @Autowired
    private ChopService chopService;

    @Autowired
    private CarService carService;

    @GetMapping("/TradeInfo")
    String tradeInfo(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:/Login";
        }
        User user=(User) httpSession.getAttribute("user");
        model.addAttribute("car_bought",tradeService.getCarBoughtByUserAccount(user.getUser_account()));
        model.addAttribute("car_sold",tradeService.getAllCarSoldByUserAccount(user.getUser_account()));
        model.addAttribute("chop",chopService.getChopByUserAccount(user.getUser_account()));
        model.addAttribute("chopped",chopService.getChoppedByUserAccount(user.getUser_account()));
        return "user/Trade-Info";
    }

    @GetMapping("/RemoveCar")
    String removeCar(@RequestParam("id")int id, HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:/Login";
        }
        User user=(User)httpSession.getAttribute("user");
        Car car=carService.getCarById(id);
        if(!car.getUser().getUser_account().equals(user.getUser_account())){
            return "redirect:/Login";
        }
        tradeService.deleteCar(car);
        return "redirect:/TradeInfo";
    }
}
