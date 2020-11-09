package com.prokarma.engineering.customer.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CustomerConsumerServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerConsumerServiceApplication.class, args);
  }

  @GetMapping("/")
  public String landingPage() {
    return "<h2>Consumer Microservice v1.0</h2>";
  }
}
