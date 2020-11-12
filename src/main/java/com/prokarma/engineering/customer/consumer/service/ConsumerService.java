package com.prokarma.engineering.customer.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.engineering.customer.consumer.constants.ConsumerServiceConstants;
import com.prokarma.engineering.customer.consumer.dao.ConsumerDao;
import com.prokarma.engineering.customer.consumer.domain.CustomerRequest;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;
import com.prokarma.engineering.customer.consumer.util.ObjectMapperUtil;

@Service
public class ConsumerService {
  @Autowired
  private ConsumerDao consumerDao;

  public void logCustomer(String input) {
    try {
      CustomerRequest customer = new ObjectMapper().readValue(input, CustomerRequest.class);
      customer.setStatus(customer.getCustomerStatus().name());
      customer.setCustomerStatus(null);
      String payload = ObjectMapperUtil.returnJsonFromObject(customer);
      consumerDao.auditLog(new AuditLog(customer.getCustomerNumber(), payload));
    } catch (Exception ex) {
      consumerDao.errorLog(new ErrorLog(ex.getClass().getName(),
          ConsumerServiceConstants.MESSAGE_DESERIALIZE_EXCEPTION, input));
    }

  }

}
