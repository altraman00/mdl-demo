package com.mdl.home.controller;

import com.mdl.home.service.UserToolsCategorySiteService;
import com.mdl.home.vo.ToolsSiteVO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Project : mdl-demo
 * @Package Name : com.mdl.home.controller
 * @Author : xiekun
 * @Desc :
 * @Create Date : 2021年01月07日 23:31
 * ----------------- ----------------- -----------------
 */

@RequestMapping("/open")
@RestController
public class OpenController {

  @Autowired
  private UserToolsCategorySiteService siteService;

  @RequestMapping("/site/{username}")
  public Map<String, List<ToolsSiteVO>> home(
      @RequestParam(value = "username", required = false, defaultValue = "admin") String userId) {
    Map<String, List<ToolsSiteVO>> siteList = siteService.findByUsername(userId);
    return siteList;
  }

}
