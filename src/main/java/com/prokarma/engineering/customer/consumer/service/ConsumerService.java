package com.prokarma.engineering.customer.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.engineering.customer.consumer.converters.ConsumerConverter;
import com.prokarma.engineering.customer.consumer.dao.ConsumerDao;
import com.prokarma.engineering.customer.consumer.domain.CustomerRequest;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;

@Service
public class ConsumerService {
  @Autowired
  private ConsumerDao consumerDao;

  @Autowired
  private ConsumerConverter consumerConverter;

  public void logCustomer(String input) {
    try {
      CustomerRequest customer = new ObjectMapper().readValue(input, CustomerRequest.class);
      consumerDao.auditLog(new AuditLog(customer.getCustomerNumber(), input));
    } catch (Exception ex) {
      consumerDao.errorLog(new ErrorLog(ex.getClass().getName(), ex.getMessage(), input));
      ex.printStackTrace();
    }

  }

}
