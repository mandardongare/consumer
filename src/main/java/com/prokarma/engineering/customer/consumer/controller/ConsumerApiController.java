package com.prokarma.engineering.customer.consumer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prokarma.engineering.customer.consumer.model.AuditLog;
import com.prokarma.engineering.customer.consumer.repo.AuditLogRepository;

@RestController
@RequestMapping("/v1/consumer")
public class ConsumerApiController {

  @Autowired
  AuditLogRepository auditLogRepository;

  @GetMapping("/audit")
  public ResponseEntity<List<AuditLog>> getAuditRecords() {
    List<AuditLog> audits = auditLogRepository.findAll();
    return new ResponseEntity<>(audits, HttpStatus.OK);
  }

}
