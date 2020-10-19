package com.mdl.day02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.mdl.day02.mapper")
@ComponentScan(basePackages = {"com.mdl.day02.*"})
public class Day02Application {

  public static void main(String[] args) {
    SpringApplication.run(Day02Application.class, args);
  }

}
