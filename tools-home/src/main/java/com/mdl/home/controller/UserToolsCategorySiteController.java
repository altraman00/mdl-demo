package com.mdl.home.controller;


import com.mdl.home.service.UserToolsCategorySiteService;
import com.mdl.home.vo.ToolsSiteVO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/home")
@Controller
public class UserToolsCategorySiteController {

  @Autowired
  private UserToolsCategorySiteService siteService;

  @RequestMapping("/site/{username}")
  public String home(Model model
      , @RequestParam(value = "username", required = false, defaultValue = "admin") String username) {
    Map<String, List<ToolsSiteVO>> categorySiteList = siteService.findByUsername(username);
    model.addAttribute("categorySiteList", categorySiteList);
    return "tools_site";
  }

}
