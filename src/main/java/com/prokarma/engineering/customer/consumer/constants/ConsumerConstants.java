package com.prokarma.engineering.customer.consumer.constants;

public enum ConsumerConstants {
  SUCCESS("success"), FAIL("fail"), NUMBER_MASK("\\w(?<=\\w{7})"), DATE_MASK(
      "\\d(?=[^-]*?-)"), EMAIL_MASK1("(?<=.{3}).(?=[^@]*?@)"), EMAIL_MASK("(^.{0,4})");

  private ConsumerConstants(String value) {
    this.value = value;
  }

  private String value;

  public String getValue() {
    return value;
  }

}
