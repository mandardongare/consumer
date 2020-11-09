package com.prokarma.engineering.customer.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prokarma.engineering.customer.consumer.model.AuditLog;

@Repository
public interface AuditLogRepo extends JpaRepository<AuditLog, Long> {

}
