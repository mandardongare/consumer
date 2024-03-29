package com.prokarma.engineering.customer.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;

@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {

}
