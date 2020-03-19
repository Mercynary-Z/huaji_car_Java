package com.huajicar.demo.controller;

import com.huajicar.demo.entity.Comment;
import com.huajicar.demo.entity.User;
import com.huajicar.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class contactUsController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/ContactUs")
    String contactUs(Model model, HttpSession httpSession){
        return "Contact-Us";
    }

    @PostMapping("/ContactUs")
    @ResponseBody
    String submitComment(Comment comment, HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "failed";
        }else {
            User user=(User)httpSession.getAttribute("user");
            comment.setUser_account(user.getUser_account());
            commentService.addComment(comment);
            return "ok";
        }
    }
}
