package com.prokarma.engineering.customer.consumer.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.model.ErrorLog;
import com.prokarma.engineering.customer.consumer.repo.ErrorLogRepository;
import com.prokarma.engineering.customer.consumer.util.ObjectMapperUtil;

@Aspect
@Component
public class DataLayerExecutionAspect {

  private Logger logger = LoggerFactory.getLogger(DataLayerExecutionAspect.class);

  @Autowired
  private ErrorLogRepository errorLogRepository;


  @AfterThrowing(
      pointcut = "com.prokarma.engineering.customer.consumer.aop.CommonJoinPointConfig.dataLayerExecution()",
      throwing = "ex")
  public void afterThrowingException(JoinPoint joinPoint, Throwable ex) {
    String methodName = joinPoint.getSignature().getName();
    String className = joinPoint.getTarget().getClass().getName();
    String arguments = ObjectMapperUtil.returnJsonFromObject(joinPoint.getArgs());
    ErrorLog errorLog = new ErrorLog(ex.getClass().getName(), ex.getMessage(), arguments);

    logger.error("Caught Exception in class: {} of method: {} and exception {}", className,
        methodName, ex.getMessage());
    try {
      errorLogRepository.save(errorLog);
    } catch (DataAccessException e) {
      logger.error("Failed to log error into ERROR_LOG: ", e);
    }

  }


}
