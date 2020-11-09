package com.prokarma.engineering.customer.publisher.converters;

import java.io.Serializable;

class CustomerAddress {

  private String addressLine1 = null;
  private String addressLine2 = null;
  private String street = null;
  private String postalCode = null;

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public String toString() {
    return "CustomerAddress [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
        + ", street=" + street + ", postalCode=" + postalCode + "]";
  }

}


public class CustomerPublisher implements Serializable {

  /**
  *
  */
  private static final long serialVersionUID = 1L;

  private String customerNumber = null;
  private String firstName = null;
  private String lastName = null;
  private String birthdate = null;
  private String country = null;
  private String countryCode = null;
  private String mobileNumber = null;
  private String email = null;
  private CustomerAddress address;
  private String customerStatus;

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CustomerAddress getAddress() {
    return address;
  }

  public void setAddress(CustomerAddress address) {
    this.address = address;
  }

  public String getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(String customerStatus) {
    this.customerStatus = customerStatus;
  }

  @Override
  public String toString() {
    return "CustomerPublisher [customerNumber=" + customerNumber + ", firstName=" + firstName
        + ", lastName=" + lastName + ", birthdate=" + birthdate + ", country=" + country
        + ", countryCode=" + countryCode + ", mobileNumber=" + mobileNumber + ", email=" + email
        + ", address=" + address + ", customerStatus=" + customerStatus + "]";
  }

  public CustomerPublisher() {
    super();
    // TODO Auto-generated constructor stub
  }



}
