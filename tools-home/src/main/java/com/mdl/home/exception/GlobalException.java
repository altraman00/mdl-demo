package com.mdl.home.exception;

import lombok.Data;

/**
 * @Project : java
 * @Package Name : com.mdl.order.exception
 * @Description : TODO
 * @Author : xiekun
 * @Create Date : 2020年09月16日 16:05
 * ----------------- ----------------- -----------------
 */

@Data
public class GlobalException extends RuntimeException {

  private Integer code;
  private String msg;
  private Object data;

  public GlobalException(String message) {
    super(message);
  }

  public GlobalException(ResultCode resultCode) {
    super(resultCode.get().getMsg());
    this.code = resultCode.get().getCode();
  }

  public GlobalException(String message, Object data) {
    super(message);
    this.data = data;
  }

  public GlobalException(String message, String msg) {
    super(message);
    this.msg = msg;
  }

  public GlobalException(String message, String msg, Object data) {
    super(message);
    this.msg = msg;
    this.data = data;
  }

  public GlobalException(String message, Throwable cause) {
    super(message, cause);
  }

  public GlobalException(String message, Object data, Throwable cause) {
    super(message, cause);
    this.data = data;
  }

  public GlobalException(String message, String msg, Throwable cause) {
    super(message, cause);
    this.msg = msg;
  }

  public GlobalException(String message, String msg, Object data, Throwable cause) {
    super(message, cause);
    this.msg = msg;
    this.data = data;
  }


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }


}
