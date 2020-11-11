package com.prokarma.engineering.customer.consumer.domain;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-11-04T09:27:23.178Z")



public class CustomerRequest {
  @JsonProperty("customerNumber")
  private String customerNumber = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("birthdate")
  private String birthdate = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("countryCode")
  private String countryCode = null;

  @JsonProperty("mobileNumber")
  private String mobileNumber = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("address")
  private CustomerAddress address = null;

  /**
   * Account status for the retrieved RetailCustomer
   */
  public enum CustomerStatusEnum {
    OPEN("Open"),

    CLOSED("Closed"),

    SUSPENDED("Suspended"),

    RESERVED("Restored");

    private String value;

    CustomerStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CustomerStatusEnum fromValue(String text) {
      for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("customerStatus")
  private CustomerStatusEnum customerStatus = null;

  public CustomerRequest customerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
    return this;
  }

  /**
   * Customer number
   * 
   * @return customerNumber
   **/
  @ApiModelProperty(example = "C000000001", required = true, value = "Customer number")
  @NotNull(message = "The field customerNumber is required")
  @Pattern(regexp = "^[a-zA-Z0-9]{10}$",
      message = "The field customerNumber is invalid. The field customerNumber can be alphanumeric with max length of 10")
  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public CustomerRequest firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name
   * 
   * @return firstName
   **/
  @ApiModelProperty(example = "Joe", required = true, value = "First name")
  @NotNull(message = "The field firstName is required")
  @Pattern(regexp = "^[A-Za-z- ]+{50}$",
      message = "The field firstName is invalid. The field firstName must be alphabetic with max length of 50")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CustomerRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * First name
   * 
   * @return lastName
   **/
  @ApiModelProperty(example = "Biden", required = true, value = "First name")
  @NotNull(message = "The field lastName is required")
  @Pattern(regexp = "^[A-Za-z- ]+{50}$",
      message = "The field lastName is invalid. The field lastName must be alphabetic with max length of 50")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CustomerRequest birthdate(String birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Birth date
   * 
   * @return birthdate
   **/
  @ApiModelProperty(example = "20-10-1959", required = true, value = "Birth date")
  @NotNull(message = "The field birthdate is required")

  @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$",
      message = "The field birthdate is invalid. The field birthdate must be date with max length of 10")
  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public CustomerRequest country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Country Name
   * 
   * @return country
   **/
  @ApiModelProperty(example = "India", required = true, value = "Country Name")
  @NotNull(message = "The field country is required")

  @Pattern(regexp = "^[A-Za-z0-9- ]+{40}$",
      message = "The field country is invalid. The field country must be alphabetic with max length of 50")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public CustomerRequest countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Country code
   * 
   * @return countryCode
   **/
  @ApiModelProperty(example = "IN", required = true, value = "Country code")
  @NotNull(message = "The field countryCode is required")

  @Pattern(regexp = "^[a-zA-Z]{2}$",
      message = "The field countryCode is invalid. The field countryCode must be alphabetic with max length of 2")
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public CustomerRequest mobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  /**
   * Mobile Number without region code
   * 
   * @return mobileNumber
   **/
  @ApiModelProperty(example = "9082312348", required = true,
      value = "Mobile Number without region code")
  @NotNull(message = "The field mobileNumber is required")

  @Pattern(regexp = "^[0-9]{10}$",
      message = "The field mobileNumber is invalid. The field mobileNumber must be numeric with max length of 10")
  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public CustomerRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email
   * 
   * @return email
   **/
  @ApiModelProperty(example = "mandard@pkglobal.com", required = true, value = "Email")
  @NotNull(message = "The field email is required")

  @Pattern(regexp = ".+@.+\\..+",
      message = "The field email is invalid. The field email can be alphanumeric with max length of 50")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CustomerRequest address(CustomerAddress address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * 
   * @return address
   **/
  @ApiModelProperty(value = "")
  @Valid

  public CustomerAddress getAddress() {
    return address;
  }

  public void setAddress(CustomerAddress address) {
    this.address = address;
  }

  public CustomerRequest customerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
    return this;
  }

  /**
   * Account status for the retrieved RetailCustomer
   * 
   * @return customerStatus
   **/
  @ApiModelProperty(example = "Open", required = true,
      value = "Account status for the retrieved RetailCustomer")
  @NotNull(
      message = "The field customerStatus is required. The value of status can only contain any one of Open , Closed , Suspended or Restored")
  public CustomerStatusEnum getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerRequest customerRequest = (CustomerRequest) o;
    return Objects.equals(this.customerNumber, customerRequest.customerNumber)
        && Objects.equals(this.firstName, customerRequest.firstName)
        && Objects.equals(this.lastName, customerRequest.lastName)
        && Objects.equals(this.birthdate, customerRequest.birthdate)
        && Objects.equals(this.country, customerRequest.country)
        && Objects.equals(this.countryCode, customerRequest.countryCode)
        && Objects.equals(this.mobileNumber, customerRequest.mobileNumber)
        && Objects.equals(this.email, customerRequest.email)
        && Objects.equals(this.address, customerRequest.address)
        && Objects.equals(this.customerStatus, customerRequest.customerStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerNumber, firstName, lastName, birthdate, country, countryCode,
        mobileNumber, email, address, customerStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerRequest {\n");

    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

