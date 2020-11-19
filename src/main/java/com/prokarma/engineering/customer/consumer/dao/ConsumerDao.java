package com.prokarma.engineering.customer.consumer.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;
import com.prokarma.engineering.customer.consumer.repo.AuditLogRepository;
import com.prokarma.engineering.customer.consumer.repo.ErrorLogRepository;

@Component
public class ConsumerDao {

  private Logger logger = LoggerFactory.getLogger(ConsumerDao.class);

  @Autowired
  private AuditLogRepository auditLogRepository;
  @Autowired
  private ErrorLogRepository errorLogRepository;

  public void auditLog(AuditLog log) {
    try {
      auditLogRepository.save(log);
    } catch (DataAccessException ex) {
      logger.error("Failed to log into AUDIT_LOG table {0} ", ex);
    }
  }

  public void errorLog(ErrorLog log) {
    try {
      errorLogRepository.save(log);
    } catch (DataAccessException ex) {
      logger.error("Failed to log into ERROR_LOG table {0} ", ex);
    }
  }

}
