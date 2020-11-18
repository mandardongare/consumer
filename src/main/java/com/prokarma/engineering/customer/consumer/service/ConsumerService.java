package com.prokarma.engineering.customer.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prokarma.engineering.customer.consumer.converter.ConsumerMaskConverter;
import com.prokarma.engineering.customer.consumer.dao.ConsumerDao;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.util.ObjectMapperUtil;
import com.prokarma.engineering.customer.publisher.dto.CustomerDTO;

@Service
public class ConsumerService {

  private Logger logger = LoggerFactory.getLogger(ConsumerService.class);

  @Autowired
  private ConsumerDao consumerDao;

  @Autowired
  private ConsumerMaskConverter consumerMaskConverter;

  public void logCustomer(CustomerDTO input) {
    try {
      consumerMaskConverter.convert(input);
      String customerNumber = input.getCustomerNumber();
      consumerDao
          .auditLog(new AuditLog(customerNumber, ObjectMapperUtil.returnJsonFromObject(input)));
    } catch (Exception e) {
      logger.error("Exception occured while processing: {0}", e);
    }
  }
}
