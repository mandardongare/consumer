package com.prokarma.engineering.customer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.service.ConsumerService;

@Component
@EnableKafka
public class CustomerConsumerListener {

  private static final Logger LOG = LoggerFactory.getLogger(CustomerConsumerListener.class);

  @Autowired
  private ConsumerService consumerService;

  @KafkaListener(topics = "${cloudkarafka.topic}")
  public void getMessageFromTopic(String customer) {
    LOG.info("Consumed: " + customer);
    consumerService.logCustomer(customer);
  }

}
