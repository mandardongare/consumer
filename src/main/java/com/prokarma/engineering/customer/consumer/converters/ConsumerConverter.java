package com.prokarma.engineering.customer.consumer.converters;

import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.DTO.CustomerDTO;
import com.prokarma.engineering.customer.consumer.constants.ConsumerServiceConstants;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;
import com.prokarma.engineering.customer.consumer.util.ObjectMapperUtil;
import com.prokarma.engineering.customer.publisher.converters.CustomerPublisher;

@Component
public class ConsumerConverter {

  public Object convert(CustomerDTO customer) {
    Object log = null;
    if (customer == null) {
      return log;
    }
    String payload = ObjectMapperUtil.returnJsonFromObject(customer);
    if (ConsumerServiceConstants.STATUS_SUCCESS.equals(customer.getStatus())) {
      AuditLog audit = new AuditLog(customer.getCustomerNumber(), payload);
      return audit;
    } else {
      ErrorLog error =
          new ErrorLog(customer.getErrorType(), customer.getErrorDescription(), payload);
      return error;
    }
  }

  public ErrorLog convertToErrorLog(String errorType, String errorDescription,
      CustomerPublisher customerData) {
    ErrorLog log = null;
    if (customerData == null) {
      return log;
    }
    String payload = ObjectMapperUtil.returnJsonFromObject(customerData);
    log = new ErrorLog(errorType, errorDescription, payload);
    return log;
  }

}
