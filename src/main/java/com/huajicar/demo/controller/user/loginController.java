package com.huajicar.demo.controller.user;

import com.huajicar.demo.entity.User;
import com.huajicar.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URL;

@Controller
public class loginController {
    @Autowired
    private UserService userService;

    @GetMapping("/Login")
    String login(Model model, HttpSession httpSession, HttpServletRequest httpServletRequest){
        httpSession.setAttribute("Referer", httpServletRequest.getHeader("Referer"));
        return "/user/Login";
    }

    @PostMapping("/Login")
    String login(@RequestParam(value = "username")String username, @RequestParam(value = "password")String password, Model model,
                 RedirectAttributes redirectAttributes, HttpSession httpSession){
        User user=userService.checkUserPassword(username,password);
        if(user!=null){
            user.setUser_password("");
            httpSession.setAttribute("user",user);
            if(httpSession.getAttribute("Referer")==null){
                return "redirect:/index";
            }else {
                String path=httpSession.getAttribute("Referer").toString();
                String[] relpath=path.split("/");
                if(relpath[relpath.length-1].equals("Login")){
                    return "redirect:/index";
                }
                return "redirect:"+httpSession.getAttribute("Referer").toString();
            }
        }else {
            redirectAttributes.addFlashAttribute("message","账号或密码错误");
            return "redirect:/Login";
        }
    }

    @PostMapping("/Register")
    String register(@RequestParam(value = "username")String username,@RequestParam("email")String email,@RequestParam(value = "password")String password,RedirectAttributes redirectAttributes){
        User user=userService.checkDuplicateUser(username);
        if(user!=null){
            redirectAttributes.addFlashAttribute("message_reg_failed","用户名已被注册");
            return "redirect:/Login";
        }else {
            userService.registerUser(username,email,password);
            redirectAttributes.addFlashAttribute("message_reg_ok","注册成功，请登录");
            return "redirect:/Login";
        }
    }

    @PostMapping("/Logout")
    @ResponseBody
    String logout(Model model,HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "ok";
    }
}
