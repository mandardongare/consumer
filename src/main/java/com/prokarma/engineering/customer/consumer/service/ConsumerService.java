package com.prokarma.engineering.customer.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.engineering.customer.consumer.constants.ConsumerServiceConstants;
import com.prokarma.engineering.customer.consumer.converter.ConsumerMaskConverter;
import com.prokarma.engineering.customer.consumer.dao.ConsumerDao;
import com.prokarma.engineering.customer.consumer.dto.CustomerDTO;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;
import com.prokarma.engineering.customer.consumer.util.ObjectMapperUtil;

@Service
public class ConsumerService {

  @Autowired
  private ConsumerDao consumerDao;

  public String logCustomer(String input) throws Exception {
    try {
      CustomerDTO customer = new ObjectMapper().readValue(input, CustomerDTO.class);
      ConsumerMaskConverter consumerMaskConverter = new ConsumerMaskConverter();
      customer = consumerMaskConverter.convert(customer);
      String customerNumber = customer.getCustomerNumber();
      auditLog(customerNumber, ObjectMapperUtil.returnJsonFromObject(customer));
      return ConsumerServiceConstants.MESSAGE_CONSUMPTION_SUCCESS;
    } catch (Exception ex) {
      String errorType = ex.getClass().getName();
      String errorDescription = ConsumerServiceConstants.MESSAGE_DESERIALIZE_EXCEPTION;
      errorLog(errorType, errorDescription, input);
      throw ex;
    }

  }

  private String auditLog(String customerNumber, String payload) {
    try {
      consumerDao.auditLog(new AuditLog(customerNumber, payload));
      return ConsumerServiceConstants.MESSAGE_AUDITLOG_SUCCESS;
    } catch (Exception e) {
      throw e;
    }
  }

  private String errorLog(String errorType, String errorDescription, String payload) {
    try {
      consumerDao.errorLog(new ErrorLog(errorType, errorDescription, payload));
      return ConsumerServiceConstants.MESSAGE_ERRORLOG_SUCCESS;
    } catch (Exception e) {
      throw e;
    }
  }

}
