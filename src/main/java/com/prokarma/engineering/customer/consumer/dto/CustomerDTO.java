package com.prokarma.engineering.customer.consumer.dto;

public class CustomerDTO {

  private String customerNumber;
  private String firstName;
  private String lastName;
  private String birthDate;
  private String country;
  private String countryCode;
  private String mobileNumber;
  private String email;
  private String addressLine1;
  private String addressLine2;
  private String street;
  private String postalCode;
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

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
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

  public String getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(String customerStatus) {
    this.customerStatus = customerStatus;
  }

  public CustomerDTO() {
    super();
  }

  public CustomerDTO(CustomerDTO copy) {
    customerNumber = copy.customerNumber;
    firstName = copy.firstName;
    lastName = copy.lastName;
    birthDate = copy.birthDate;
    country = copy.country;
    countryCode = copy.countryCode;
    mobileNumber = copy.mobileNumber;
    email = copy.email;
    addressLine1 = copy.addressLine1;
    addressLine2 = copy.addressLine2;
    street = copy.street;
    postalCode = copy.postalCode;
    customerStatus = copy.customerStatus;
  }

  @Override
  public String toString() {
    return "CustomerDTO [customerNumber=" + customerNumber + ", firstName=" + firstName
        + ", lastName=" + lastName + ", birthDate=" + birthDate + ", country=" + country
        + ", countryCode=" + countryCode + ", mobileNumber=" + mobileNumber + ", email=" + email
        + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", street=" + street
        + ", postalCode=" + postalCode + ", customerStatus=" + customerStatus + "]";
  }

}
