package com.mobvoi.demo.controller;

import com.mobvoi.demo.entity.SysUserEntity;
import com.mobvoi.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project : mobvoi-demo
 * @Package Name : com.mdl.mobvoi
 * @Description : TODO
 * @Author : knight
 * @Create Date : 2020年08月24日 16:11
 * @ModificationHistory Who   When     What
 * ------------    --------------    ---------------------------------
 */

@Api(value = "UserController", tags = "用户相关")
@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @ApiOperation(value = "根据id查询")
  @GetMapping("/name")
  public String bridgeInfo(String id) {
    String byId = userService.findById(id);
    return byId;

  }

}
