package com.mdl.demo.controller;

import com.mdl.demo.patterns.chainpattern03.handler.CostHandler;
import com.mdl.demo.patterns.chainpattern03.model.Task;
import com.mdl.demo.patterns.chainpattern05.ExecuteHandler;
import com.mdl.demo.patterns.chainpattern05.Handler;
import com.mdl.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @Autowired
  private List<CostHandler> filters;

  @Autowired
  private ExecuteHandler executeHandler;

  @ApiOperation(value = "根据id查询")
  @GetMapping("/name")
  public String bridgeInfo(String id) {
    String byId = userService.findById(id);
    return byId;
  }

  @ApiOperation(value = "检验责任链的order注解")
  @GetMapping("/chain")
  public String testChain() {
    Task task = new Task();
    for (CostHandler filter : filters) {
      if (!filter.filter(task)) {
        return "error";
      }
    }
    return "ok";
  }

  /**
   * 测试责任链模式
   */
  @GetMapping("/test/{num}")
  public String testHandler(@PathVariable float num) {
    Handler handler = executeHandler.getHandler();
    handler.dealRequest(num);
    return "ok";
  }


}
