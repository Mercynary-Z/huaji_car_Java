package com.huajicar.demo.controller.admin;

import com.huajicar.demo.entity.Admin;
import com.huajicar.demo.entity.Agent;
import com.huajicar.demo.entity.User;
import com.huajicar.demo.service.AdminService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class AdminLoginController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/AdminLogin")
    String adminLogin(HttpSession httpSession){
        return "admin/Admin-Login";
    }

    @PostMapping("/AdminLogin")
    @ResponseBody
    String checkAccount(Admin admin,HttpSession httpSession){
        Admin ad=adminService.checkLogin(admin);
        if(ad!=null){
            httpSession.setAttribute("admin",ad);
            return "ok";
        }else {
            return "failed";
        }
    }


    @PostMapping("AdminLogout")
    @ResponseBody
    String adminLogout(HttpSession httpSession){
        httpSession.removeAttribute("admin");
        return "ok";
    }
}
