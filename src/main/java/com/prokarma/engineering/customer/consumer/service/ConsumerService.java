package com.prokarma.engineering.customer.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.engineering.customer.consumer.constants.ConsumerServiceConstants;
import com.prokarma.engineering.customer.consumer.dao.ConsumerDao;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.model.CustomerDTO;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;

@Service
public class ConsumerService {
  @Autowired
  private ConsumerDao consumerDao;

  public void logCustomer(String input) {
    try {
      CustomerDTO customer = new ObjectMapper().readValue(input, CustomerDTO.class);
      String customerNumber = customer.getCustomerNumber();
      auditLog(customerNumber, input);
    } catch (Exception ex) {
      String errorType = ex.getClass().getName();
      String errorDescription = ConsumerServiceConstants.MESSAGE_DESERIALIZE_EXCEPTION;
      errorLog(errorType, errorDescription, input);
    }

  }

  private void auditLog(String customerNumber, String payload) {
    try {
      consumerDao.auditLog(new AuditLog(customerNumber, payload));
    } catch (Exception e) {
    }
  }

  private void errorLog(String errorType, String errorDescription, String payload) {
    try {
      consumerDao.errorLog(new ErrorLog(errorType, errorDescription, payload));
    } catch (Exception e) {
    }
  }

}
