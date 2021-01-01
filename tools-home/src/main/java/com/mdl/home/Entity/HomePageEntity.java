package com.mdl.home.Entity;

import lombok.Data;

/**
 * @Project : mdl-demo
 * @Package Name : com.mdl.home
 * @Author : xiekun
 * @Desc :
 * @Create Date : 2021年01月01日 22:34
 * ----------------- ----------------- -----------------
 */

@Data
public class HomePageEntity {

  private String title;

  private String content;

  private String img;

  public HomePageEntity(String title, String content, String img) {
    this.title = title;
    this.content = content;
    this.img = img;
  }

}
