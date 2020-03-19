package com.huajicar.demo.controller.admin;

import com.huajicar.demo.entity.Agent;
import com.huajicar.demo.entity.Trade;
import com.huajicar.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
public class manageController {
    @Autowired
    private UserService userService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private TradeService tradeService;

    @Autowired
    private CarService carService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/Manage")
    String manage(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("admin")!=null){
            model.addAttribute("userCount",userService.getCount());
            model.addAttribute("tradeCount",tradeService.getCount());
            model.addAttribute("commentCount",commentService.getCount());
            model.addAttribute("agentCount",agentService.getCount());
            model.addAttribute("carCount",carService.getCount());
            model.addAttribute("cars",adminService.getAllCar());
            model.addAttribute("comments",adminService.getAllComment());
            model.addAttribute("agents",adminService.getAllAgent());
            model.addAttribute("users",adminService.getAllUser());
            return "admin/Manage";
        }else {
            return "redirect:/AdminLogin";
        }
    }


    @PostMapping("/AddAgent")
    @ResponseBody
    String addAgent(@RequestParam("files") MultipartFile file, Agent agent, HttpSession httpSession){
        if(httpSession.getAttribute("admin")!=null&&!file.isEmpty()){
            if(adminService.checkDuplicateAgent(agent)){
                return "failed";
            }
            adminService.addAgent(agent,file);
            return "ok";
        }else {
            return "failed";
        }
    }

    @GetMapping("/DeleteComment")
    String deleteComment(@RequestParam("id")int id, HttpSession httpSession){
        if(httpSession.getAttribute("admin")==null){
            return "redirect:/Login";
        }
        adminService.deleteCommentById(id);
        return "redirect:/Manage";
    }
}
