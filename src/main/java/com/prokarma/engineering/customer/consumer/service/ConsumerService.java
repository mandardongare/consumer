package com.prokarma.engineering.customer.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prokarma.engineering.customer.DTO.CustomerDTO;
import com.prokarma.engineering.customer.consumer.constants.ConsumerServiceConstants;
import com.prokarma.engineering.customer.consumer.converters.ConsumerConverter;
import com.prokarma.engineering.customer.consumer.dao.ConsumerDao;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;

@Service
public class ConsumerService {
  @Autowired
  private ConsumerDao consumerDao;

  @Autowired
  private ConsumerConverter consumerConverter;

  public void logCustomer(CustomerDTO customer) {
    Object log = consumerConverter.convert(customer);
    if (ConsumerServiceConstants.STATUS_SUCCESS.equals(customer.getStatus())) {
      consumerDao.auditLog((AuditLog) log);
    } else {
      consumerDao.errorLog((ErrorLog) log);
    }
  }

}
