package com.huajicar.demo.controller.user;

import com.huajicar.demo.entity.User;
import com.huajicar.demo.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

@Controller
public class userInfoController {
    @Autowired
    private UserService userService;

    @GetMapping("/UserInfo")
    String getUserInfo(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:Login";
        }
        User user=(User) httpSession.getAttribute("user");
        user=userService.getUserByAccount(user.getUser_account());
//        user.setUser_password("");
        httpSession.setAttribute("user",user);
        return "user/User-Info";
    }

    @PostMapping("/UpdateUserInfo")
    String updateUserInfo(@RequestParam("user_password")String user_password, @RequestParam("user_name")String user_name, @RequestParam("user_idnumber")String user_idnumber,
                          @RequestParam("user_birthday")Date user_birthday, @RequestParam("user_gender")String user_gender, @RequestParam("user_nationality")String user_nationality,
                          @RequestParam("user_email")String user_email, @RequestParam("user_phone")String user_phone, RedirectAttributes redirectAttributes, HttpSession httpSession){
        User user=(User) httpSession.getAttribute("user");
        userService.updateUserInfo(user_password, user_name, user_idnumber, user_birthday, user_gender, user_nationality, user_email, user_phone,user.getUser_account());
        user=userService.getUserByAccount(user.getUser_account());
//        user.setUser_password("");
        httpSession.setAttribute("user",user);
        redirectAttributes.addFlashAttribute("message1","个人资料已更新");
        return "redirect:UserInfo";
    }

    @PostMapping("/UpdateUserImg")
    String updateUserImg(@RequestParam("files") MultipartFile file, HttpServletRequest request, HttpSession httpSession){
        if(!file.isEmpty()){
            String type=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
            User user=(User)httpSession.getAttribute("user");
            String filename=user.getUser_account()+"-img"+type;
//            String path=request.getSession().getServletContext().getRealPath("/static/image/"+filename);
            String path="./src/main/resources/static/image/"+filename;
            File destFile=new File(path);
            try{
                FileUtils.copyInputStreamToFile(file.getInputStream(),destFile);
            }catch (IOException e){
                e.printStackTrace();
            }
            path="./target/classes/static/image/"+filename;
            destFile=new File(path);
            try{
                FileUtils.copyInputStreamToFile(file.getInputStream(),destFile);
            }catch (IOException e){
                e.printStackTrace();
            }
            userService.updateUserImg("/static/image/"+filename,user.getUser_account());
            httpSession.setAttribute("user",userService.getUserByAccount(user.getUser_account()));
            return "redirect:/UserInfo";
        }else {
            return "redirect:/UserInfo";
        }
    }
}
