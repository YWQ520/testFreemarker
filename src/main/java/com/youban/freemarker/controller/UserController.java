package com.youban.freemarker.controller;

import com.youban.freemarker.controller.data.Result;
import com.youban.freemarker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public String  getAll(Model model){
        model.addAttribute("result",userService.selectAll());
        return "index";
    }
}
