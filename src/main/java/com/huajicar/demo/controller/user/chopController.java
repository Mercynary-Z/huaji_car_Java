package com.huajicar.demo.controller.user;

import com.huajicar.demo.entity.Chop;
import com.huajicar.demo.entity.User;
import com.huajicar.demo.service.ChopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class chopController {
    @Autowired
    private ChopService chopService;

    @PostMapping("Chop")
    @ResponseBody
    String chop(Chop chop, HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "not login";
        }else {
            if(chop.getChop_price()<=0){
                return "no price";
            }
            User user=(User) httpSession.getAttribute("user");
            chop.setAccount_name(user.getUser_account());
            chopService.newChop(chop);
            return "ok";
        }
    }

    @GetMapping("/ApplyChop")
    String applyChop(@RequestParam("id")int id,HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:/Login";
        }else {
            User user=(User)httpSession.getAttribute("user");
            Chop chop=chopService.getChopById(id);
            chopService.applyChop(user,chop);
            return "redirect:/TradeInfo";
        }
    }

    @GetMapping("RejectChop")
    String rejectChop(@RequestParam("id")int id,HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:/Login";
        }else {
            Chop chop=chopService.getChopById(id);
            chopService.rejectChop(chop);
            return "redirect:/TradeInfo";
        }
    }
}
