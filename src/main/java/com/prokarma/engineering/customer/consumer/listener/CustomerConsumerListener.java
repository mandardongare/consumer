package com.prokarma.engineering.customer.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.service.ConsumerService;
import com.prokarma.engineering.customer.publisher.dto.CustomerDTO;

@Component
@EnableKafka
public class CustomerConsumerListener {


  @Autowired
  private ConsumerService consumerService;

  @KafkaListener(topics = "${cloudkarafka.topic}")
  public void getMessageFromTopic(@Payload CustomerDTO customer) {
    consumerService.logCustomer(customer);
  }

}
