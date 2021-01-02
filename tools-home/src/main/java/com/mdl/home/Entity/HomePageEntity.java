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

  private String url;

  private String img;

  private String content;

  public HomePageEntity(String title, String url, String img,String content) {
    this.title = title;
    this.url = url;
    this.img = img;
    this.img = content;
  }

}
