package com.mdl.demo.patterns.chainpattern05.handler;

import com.mdl.demo.patterns.chainpattern05.Handler;
import org.springframework.stereotype.Component;

/**
 * @Project : mdl-demo
 * @Package Name : com.mdl.demo.patterns.chainpattern04.handler
 * @Description : 优惠券的赠送金额的消费
 * @Author : xiekun
 * @Create Date : 2020年10月09日 17:30
 * ----------------- ----------------- -----------------
 */

@Component("MactivityCostHandler")
public class MactivityCostHandler extends Handler {

  private Handler nextHandler;

  @Override
  public Handler getNextHandler() {
    return nextHandler;
  }

  @Override
  public void setNextHandler(Handler nextHandler) {
    this.nextHandler = nextHandler;
  }

  @Override
  public void dealRequest(float num) {

    System.out.println("MactivityCostHandler:" + num);
    if (num <= 0.35) {
      System.out.format("%s消费了:%.2f%n", this.getClass().getName(), num);
    } else {
      nextHandler.dealRequest(num);
    }
  }
}
