package com.prokarma.engineering.customer.consumer.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;
import com.prokarma.engineering.customer.consumer.repo.AuditLogRepo;
import com.prokarma.engineering.customer.consumer.repo.ErrorLogRepo;

@Component
public class ConsumerDao {
  private static final Logger LOG = LoggerFactory.getLogger(ConsumerDao.class);
  @Autowired
  private AuditLogRepo auditLogRepo;
  @Autowired
  private ErrorLogRepo errorLogRepo;

  public void auditLog(AuditLog log) {
    auditLogRepo.save(log);
    System.out.println("*********** AUDIT RECORDS *********************");
    auditLogRepo.findAll().forEach(p -> System.out.println(p));
    System.out.println("****************************************");
  }

  public void errorLog(ErrorLog log) {
    errorLogRepo.save(log);
    System.out.println("************ ERROR RECORDS ****************************");
    errorLogRepo.findAll().forEach(p -> System.out.println(p));
    System.out.println("****************************************");
  }


}
