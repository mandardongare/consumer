package com.prokarma.engineering.customer.consumer.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

  @Pointcut("execution(* com.prokarma.engineering.customer.consumer.*.*.*(..))")
  public void dataLayerExecution() {}

}
