package com.prokarma.engineering.customer.consumer.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.prokarma.engineering.customer.publisher.dto.CustomerDTO;

@Tag("unit")
public class ConsumerMaskConverterTest {

  private ConsumerMaskConverter consumerMaskConverter;

  @BeforeEach
  private void setUp() {
    consumerMaskConverter = new ConsumerMaskConverter();
  }

  @Test
  void testConvertWhenPassingValidCustomerDTOObjectShouldApplyMaskingToCustomerDTOObject() {
    CustomerDTO customerDTO = consumerMaskConverter.convert(createCustomerDTO());
    assertNotNull(customerDTO);
    assertEquals("C12345****", customerDTO.getCustomerNumber());
    assertEquals("****@gmail.com", customerDTO.getEmail());
    assertEquals("**-**-2020", customerDTO.getBirthDate());
    assertEquals("S", customerDTO.getCustomerStatus());

  }

  private CustomerDTO createCustomerDTO() {
    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setCustomerNumber("C123456789");
    customerDTO.setBirthDate("22-10-2020");
    customerDTO.setEmail("abcd@gmail.com");
    customerDTO.setMobileNumber("9038476368");
    customerDTO.setFirstName("Mandar");
    customerDTO.setLastName("Dongare");
    customerDTO.setCountry("IRAN");
    customerDTO.setCountryCode("IR");
    customerDTO.setAddressLine1("Addr Line 1");
    customerDTO.setAddressLine2("Addr Line 2");
    customerDTO.setStreet("Main street");
    customerDTO.setPostalCode("410289");
    customerDTO.setCustomerStatus("Suspended");

    return customerDTO;
  }


}
