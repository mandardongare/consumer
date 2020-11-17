package com.prokarma.engineering.customer.consumer.converter;

public interface Converter<I, O> {
  O convert(I input);
}
