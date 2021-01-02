package com.mdl.home.controller;


import com.mdl.home.entity.UserToolsCategorySiteEntity;
import com.mdl.home.service.UserToolsCategorySiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/home")
@Controller
public class UserToolsCategorySiteController {

    @Autowired
    private UserToolsCategorySiteService siteService;

    @RequestMapping("/site")
    public String home(Model model,String userId) {
        List<UserToolsCategorySiteEntity> siteList = siteService.findByUserId(userId);
        model.addAttribute("siteList", siteList);
        return "home";
    }

}
