package com.prokarma.engineering.customer.consumer.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "AUDIT_LOG")
public class AuditLog implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "CUSTOMER_NUMBER")
  private String customerNumber;

  @Column(columnDefinition = "text")
  private String payload;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public AuditLog(String customerNumber, String payload) {
    super();
    this.customerNumber = customerNumber;
    this.payload = payload;
  }

  public AuditLog() {
    super();
  }

  @Override
  public String toString() {
    return "AuditLog [id=" + id + ", customerNumber=" + customerNumber + ", payload=" + payload
        + "]";
  }
}
