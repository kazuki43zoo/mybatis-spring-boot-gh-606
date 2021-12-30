package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyModuleApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyModuleApplication.class, args);
  }

  @Bean
  ApplicationRunner runner(FooMapper fooMapper, BarMapper barMapper) {
    return args -> {
      System.out.println(fooMapper.ping());
      System.out.println(barMapper.ping());
    };
  }
}
