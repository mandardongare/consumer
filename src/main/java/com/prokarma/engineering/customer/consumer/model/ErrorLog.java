package com.prokarma.engineering.customer.consumer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ERROR_LOG")
// @TypeDefs({@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
public class ErrorLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "ERROR_TYPE")
  private String errorType;
  @Column(name = "ERROR_DESCRIPTION")
  private String errorDescription;
  // @Lob
  @Column(columnDefinition = "text")
  private String payload;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public ErrorLog(String errorType, String errorDescription, String payload) {
    super();
    this.errorType = errorType;
    this.errorDescription = errorDescription;
    this.payload = payload;
  }

  public ErrorLog() {
    super();
  }

  @Override
  public String toString() {
    return "ErrorLog [id=" + id + ", errorType=" + errorType + ", errorDescription="
        + errorDescription + ", payload=" + payload + "]";
  }



}
