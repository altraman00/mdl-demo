package com.mdl.seckill.controller;

import com.mdl.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project : mdl-demo
 * @Package Name : com.mdl.seckill.controller
 * @Author : xiekun
 * @Desc :
 * @Create Date : 2021年03月06日 17:52
 * ----------------- ----------------- -----------------
 */

@RequestMapping("/open")
@RestController
public class OpenController {

  @Autowired
  private SeckillService seckillService;

  @GetMapping("/hello")
  public String queryById(String id) {
    return seckillService.queryById(id).getName();
  }

}
