package com.prokarma.engineering.customer.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.service.ConsumerService;

@Component
@EnableKafka
public class CustomerConsumerListener {


  @Autowired
  private ConsumerService consumerService;

  @KafkaListener(topics = "${cloudkarafka.topic}")
  public void getMessageFromTopic(String customer) {
    try {
      consumerService.logCustomer(customer);
    } catch (Exception e) {
    }
  }

}
