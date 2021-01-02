package com.mdl.home.entity;

import lombok.Data;

import javax.persistence.Column;

/**
 * @Project : mdl-demo
 * @Package Name : com.mdl.home
 * @Author : xiekun
 * @Desc :
 * @Create Date : 2021年01月01日 22:34
 * ----------------- ----------------- -----------------
 */

@Data
public class UserToolsCategoryEntity extends BaseEntity{

  @Column(name="title")
  private String title;

  @Column(name="url")
  private String url;

  @Column(name="img")
  private String img;

  @Column(name="version")
  private String content;

  public UserToolsCategoryEntity(String title, String url, String img, String content) {
    this.title = title;
    this.url = url;
    this.img = img;
    this.content = content;
  }

  public UserToolsCategoryEntity() {
  }
}
