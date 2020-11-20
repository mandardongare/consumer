package com.prokarma.engineering.customer.publisher.dto;

public enum CustomerStatusEnum {

  O("Open"),

  C("Closed"),

  S("Suspended"),

  R("Restored");

  private String value;

  CustomerStatusEnum(String value) {
    this.value = value;
  }

  public String toString() {
    return String.valueOf(value);
  }

  public static CustomerStatusEnum fromValue(String text) {
    for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
