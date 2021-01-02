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
public class UserToolsCategorySiteEntity extends BaseEntity{

  @Column(name="user_id")
  private String userId;

  @Column(name="category_id")
  private String categoryId;

  @Column(name="title")
  private String title;

  @Column(name="url")
  private String url;

  @Column(name="img")
  private String img;

  @Column(name="intro")
  private String intro;

  public UserToolsCategorySiteEntity(String title, String url, String img, String intro) {
    this.title = title;
    this.url = url;
    this.img = img;
    this.intro = intro;
  }

  public UserToolsCategorySiteEntity() {
  }
}
