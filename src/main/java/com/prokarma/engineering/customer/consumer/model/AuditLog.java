package com.prokarma.engineering.customer.consumer.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@Table(name = "AUDIT_LOG")
@TypeDefs({@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
public class AuditLog implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "CUSTOMER_NUMBER")
  private String customerNumber;
  @Column(name = "PAYLOAD", columnDefinition = "jsonb")
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
