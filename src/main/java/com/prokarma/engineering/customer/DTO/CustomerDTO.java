package com.prokarma.engineering.customer.DTO;

import java.io.Serializable;
import com.prokarma.engineering.customer.publisher.converters.CustomerPublisher;

public class CustomerDTO implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String status;
  private String customerNumber;
  private String errorType;
  private String errorDescription;
  private CustomerPublisher customer;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  public CustomerPublisher getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerPublisher customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "CustomerDTO [status=" + status + ", customerNumber=" + customerNumber + ", errorType="
        + errorType + ", errorDescription=" + errorDescription + ", customer=" + customer + "]";
  }

  public CustomerDTO(String status, String customerNumber, CustomerPublisher customer) {
    super();
    this.status = status;
    this.customerNumber = customerNumber;
    this.customer = customer;
  }

  public CustomerDTO(String status, String errorType, String errorDescription,
      CustomerPublisher customer) {
    super();
    this.status = status;
    this.errorType = errorType;
    this.errorDescription = errorDescription;
    this.customer = customer;
  }

  public CustomerDTO() {
    super();
  }
}
