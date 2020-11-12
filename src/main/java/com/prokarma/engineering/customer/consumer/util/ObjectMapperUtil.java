package com.prokarma.engineering.customer.consumer.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
  private static final Logger LOG = LoggerFactory.getLogger(ObjectMapperUtil.class);

  private ObjectMapperUtil() {
    throw new AssertionError("No Object Creation");
  }

  public static String returnJsonFromObject(Object object) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException ex) {
      LOG.error("Failed to process the json: {} with exception {}", object, ex);
      return null;
    }
  }
}
