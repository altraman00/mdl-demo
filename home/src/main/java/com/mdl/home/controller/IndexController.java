package com.mdl.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    model.addAttribute("msg", "我是第一个页面");
    return "home";
  }

}
