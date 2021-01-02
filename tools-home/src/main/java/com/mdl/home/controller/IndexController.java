package com.mdl.home.controller;

import com.mdl.home.entity.UserToolsCategorySiteEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : home
 * @Package Name : com.mdl.home.controller
 * @Author : xiekun
 * @Desc :
 * @Create Date : 2020年12月30日 22:32
 * ----------------- ----------------- -----------------
 */

@RequestMapping("/home")
@Controller
public class IndexController {

  @RequestMapping("/index")
  public String index(Model model) {
    model.addAttribute("msg", "我是第一个页面");
    return "index";
  }

  @RequestMapping("/home")
  public String home(Model model) {
    List<UserToolsCategorySiteEntity> list = new ArrayList<>();

    UserToolsCategorySiteEntity entity1 = new UserToolsCategorySiteEntity("我是title1","http://tool.oschina.net/","../static/img/logo_small.gif","我是content1");
    UserToolsCategorySiteEntity entity2 = new UserToolsCategorySiteEntity("我是title2","http://tool.oschina.net/","../static/img/logo_small.gif","我是content2");
    UserToolsCategorySiteEntity entity3 = new UserToolsCategorySiteEntity("我是title3","http://tool.oschina.net/","../static/img/logo_small.gif","我是content3");
    list.add(entity1);
    list.add(entity2);
    list.add(entity3);
    list.add(entity3);
    list.add(entity3);

    model.addAttribute("msg", "我是第一个页面");
    model.addAttribute("HomePageList",list);

    return "home";
  }

}
