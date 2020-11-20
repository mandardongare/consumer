package com.prokarma.engineering.customer.consumer.converter;

import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.constants.ConsumerConstants;
import com.prokarma.engineering.customer.publisher.dto.CustomerDTO;
import com.prokarma.engineering.customer.publisher.dto.CustomerStatusEnum;

@Component
public class ConsumerMaskConverter implements Converter<CustomerDTO, CustomerDTO> {

  @Override
  public CustomerDTO convert(CustomerDTO input) {
    CustomerDTO customer = new CustomerDTO();

    customer.setFirstName(input.getFirstName());
    customer.setLastName(input.getLastName());
    customer.setCountry(input.getCountry());
    customer.setCountryCode(input.getCountryCode());
    customer.setMobileNumber(input.getMobileNumber());
    customer.setAddressLine1(input.getAddressLine1());
    customer.setAddressLine2(input.getAddressLine2());
    customer.setStreet(input.getStreet());
    customer.setPostalCode(input.getPostalCode());
    customer.setCustomerNumber(
        input.getCustomerNumber().replaceAll(ConsumerConstants.NUMBER_MASK.getValue(), "*"));
    customer
        .setBirthDate(input.getBirthDate().replaceAll(ConsumerConstants.DATE_MASK.getValue(), "*"));
    customer.setEmail(input.getEmail().replaceAll(ConsumerConstants.EMAIL_MASK.getValue(), "*"));
    customer.setCustomerStatus(CustomerStatusEnum.fromValue(input.getCustomerStatus()).name());

    return customer;
  }

}
