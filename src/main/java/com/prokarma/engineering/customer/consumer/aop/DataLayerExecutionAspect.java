package com.prokarma.engineering.customer.consumer.aop;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.prokarma.engineering.customer.consumer.util.ObjectMapperUtil;

@Aspect
@Component
public class DataLayerExecutionAspect {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Around("com.prokarma.engineering.customer.consumer.aop.CommonJoinPointConfig.dataLayerExecution()")
  public void aroundExcecution(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = joinPoint.getSignature().getName();
    String className = joinPoint.getTarget().getClass().getName();
    String arguments = Arrays.toString(joinPoint.getArgs());

    logger.info("Method Invoked in class: {} of method: {} with arguments: {}", className,
        methodName, arguments);

    Object response = joinPoint.proceed();
    if (response != null)
      logger.info("Method Responded class: {} of method: {} with arguments: {} and response:{}",
          className, methodName, arguments, response);

  }

  @AfterThrowing(
      pointcut = "com.prokarma.engineering.customer.consumer.aop.CommonJoinPointConfig.dataLayerExecution()",
      throwing = "ex")
  public void afterThrowingException(JoinPoint joinPoint, Throwable ex) {
    String methodName = joinPoint.getSignature().getName();
    String className = joinPoint.getTarget().getClass().getName();
    String arguments = ObjectMapperUtil.returnJsonFromObject(joinPoint.getArgs());

    logger.error("Caught Exception in class: {} of method: {} with arguments: {} and exception {}",
        className, methodName, arguments, ex.getMessage());
  }


}
