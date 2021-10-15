package com.liugh.config;


import java.util.Objects;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 统一返回相应参数实体类
 *
 * @author tanghailan
 * @date 2021年10月15日 14:21
 */
public class ResponseModel<T> implements Serializable {

  private static final long serialVersionUID = -1241360949457314497L;
  private T result;
  private String message;
  private String code;

  public ResponseModel() {
    HttpServletResponse response = ((ServletRequestAttributes) Objects
        .requireNonNull(RequestContextHolder.getRequestAttributes()))
        .getResponse();
    assert response != null;
    response.setCharacterEncoding("UTF-8");
  }

  public ResponseModel(T result, String message, String code) {
    this.result = result;
    this.message = message;
    this.code = code;
  }

  public String getMessage() {
    return this.message;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  public T getResult() {
    return this.result;
  }

  public void setResult(T result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "ResponseModel [ result=" + this.result + ", message=" + this.message + ", code="
        + this.code + "]";
  }
}
