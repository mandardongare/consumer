package com.prokarma.engineering.customer.consumer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;
import com.prokarma.engineering.customer.consumer.repo.AuditLogRepo;
import com.prokarma.engineering.customer.consumer.repo.ErrorLogRepo;

@Component
public class ConsumerDao {

  @Autowired
  private AuditLogRepo auditLogRepo;
  @Autowired
  private ErrorLogRepo errorLogRepo;

  public void auditLog(AuditLog log) {
    auditLogRepo.save(log);
  }

  public void errorLog(ErrorLog log) {
    errorLogRepo.save(log);
  }

}
