package com.huajicar.demo.controller;

import com.huajicar.demo.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class aboutUsController {
    @Autowired
    private AgentService agentService;

    @GetMapping("/AboutUs")
    String aboutUs(Model model, HttpSession httpSession){
        model.addAttribute("agents",agentService.getAgentByNum(4));
        return "About-Us";
    }
}
