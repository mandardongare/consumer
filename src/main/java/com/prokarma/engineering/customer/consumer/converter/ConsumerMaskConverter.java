package com.prokarma.engineering.customer.consumer.converter;

import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.constants.ConsumerConstants;
import com.prokarma.engineering.customer.publisher.dto.CustomerDTO;

@Component
public class ConsumerMaskConverter implements Converter<CustomerDTO, CustomerDTO> {

  @Override
  public CustomerDTO convert(CustomerDTO input) {
    input.setCustomerNumber(
        input.getCustomerNumber().replaceAll(ConsumerConstants.NUMBER_MASK.getValue(), "*"));
    input
        .setBirthDate(input.getBirthDate().replaceAll(ConsumerConstants.DATE_MASK.getValue(), "*"));
    input.setEmail(input.getEmail().replaceAll(ConsumerConstants.EMAIL_MASK.getValue(), "*"));
    return input;
  }

}
