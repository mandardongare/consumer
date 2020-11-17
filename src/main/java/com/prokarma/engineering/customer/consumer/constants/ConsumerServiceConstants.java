package com.prokarma.engineering.customer.consumer.constants;

public class ConsumerServiceConstants {
  public static final String MESSAGE_DESERIALIZE_EXCEPTION = "Failed to deserialize kafka message";
  public static final String DB_OPERATION_FAILED = "Failed to log into the database";
  public static final String MESSAGE_CONSUMPTION_SUCCESS = "Successfully consumed messsage";
  public static final String MESSAGE_AUDITLOG_SUCCESS =
      "Successfully logged messsage in AUDIT_LOG ";
  public static final String MESSAGE_AUDITLOG_FAIL = "Failed to log messsage in AUDIT_LOG ";
  public static final String MESSAGE_ERRORLOG_SUCCESS =
      "Successfully logged messsage in ERROR_LOG ";
  public static final String MESSAGE_ERRORLOG_FAIL = "Failed to log messsage in ERROR_LOG ";
}
