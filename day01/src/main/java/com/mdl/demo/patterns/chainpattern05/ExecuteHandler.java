package com.mdl.demo.patterns.chainpattern05;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Project : mdl-demo
 * @Package Name : com.mdl.demo.patterns.chainpattern05
 * @Description : 职责处理器
 * @Author : xiekun
 * @Create Date : 2020年10月09日 22:04
 * ----------------- ----------------- -----------------
 */

@Component
public class ExecuteHandler {

  @Autowired
  private ApplicationContext context;

  private List<Handler> handlerList = new LinkedList<>();

  private Handler handler;

  public Handler getHandler() {
    return handler;
  }

  /**
   * 该方法会在该对象创建之后被调用
   */
  @PostConstruct
  public void afterPostConstruct() {
    HandlerBeanEnum[] values = HandlerBeanEnum.values();
    for (HandlerBeanEnum value : values) {
      Handler bean = context.getBean(value.getBeanName(), Handler.class);
      handlerList.add(bean);
    }
    if (handlerList != null && handlerList.size() > 0) {
      for (int i = 1; i < handlerList.size(); i++) {
        //当前处理器
        Handler currentHandler = handlerList.get(i - 1);
        //下一个处理器
        Handler nextHandler = handlerList.get(i);
        //将处理器串成链表
        currentHandler.setNextHandler(nextHandler);
      }
      this.handler = handlerList.get(0);
    }

  }

}
