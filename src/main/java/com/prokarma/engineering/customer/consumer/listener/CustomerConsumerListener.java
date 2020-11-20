package com.prokarma.engineering.customer.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.converter.ConsumerMaskConverter;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.repo.AuditLogRepository;
import com.prokarma.engineering.customer.consumer.util.ObjectMapperUtil;
import com.prokarma.engineering.customer.publisher.dto.CustomerDTO;

@Component
@EnableKafka
public class CustomerConsumerListener {

  private static final Logger logger = LoggerFactory.getLogger(CustomerConsumerListener.class);

  @Autowired
  AuditLogRepository auditLogRepository;

  @Autowired
  private ConsumerMaskConverter consumerMaskConverter;

  @KafkaListener(topics = "${cloudkarafka.topic}")
  public void getMessageFromTopic(@Payload CustomerDTO customer) {
    CustomerDTO maskedCustomer = consumerMaskConverter.convert(customer);
    logger.info("Consumed message: {}", maskedCustomer);
    auditLogCustomer(maskedCustomer);
  }

  private void auditLogCustomer(CustomerDTO customerDTO) {
    AuditLog auditLog = new AuditLog();
    auditLog.setCustomerNumber(customerDTO.getCustomerNumber());
    auditLog.setPayload(ObjectMapperUtil.returnJsonFromObject(customerDTO));
    long startTime = System.currentTimeMillis();
    auditLogRepository.save(auditLog);
    logger.info("Customer audit log saved in time: {}ms", System.currentTimeMillis() - startTime);
  }

}
