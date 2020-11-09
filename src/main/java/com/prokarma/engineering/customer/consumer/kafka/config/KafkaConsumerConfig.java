// package com.prokarma.engineering.customer.consumer.kafka.config;
//
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
// import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
// import org.springframework.kafka.config.KafkaListenerContainerFactory;
// import org.springframework.kafka.core.ConsumerFactory;
// import com.fasterxml.jackson.annotation.JsonAutoDetect;
// import com.fasterxml.jackson.annotation.PropertyAccessor;
// import com.fasterxml.jackson.databind.DeserializationFeature;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.prokarma.engineering.customer.DTO.CustomerDTO;
//
// @Configuration
// public class KafkaConsumerConfig {
//

/*
 * @Bean public ConsumerFactory<String, CustomerDTO> consumerFactory() { Map<String, Object> configs
 * = new HashMap<>(); configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
 * configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
 * configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
 * configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group1"); // configs.put(ConsumerConfig.ER, value)
 * return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new
 * JsonDeserializer<>(CustomerDTO.class)); }
 * 
 * @Bean public ConcurrentKafkaListenerContainerFactory<String, CustomerDTO>
 * customerKafkaListenerContainerFactory() { ConcurrentKafkaListenerContainerFactory<String,
 * CustomerDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
 * factory.setConsumerFactory(consumerFactory()); return factory; }
 */

// @Value("${spring.kafka.bootstrap-servers}")
// private String bootstrapServer;
// @Value("${spring.kafka.properties.security.protocol}")
// private String securityProtocol;
// @Value("${spring.kafka.concurrentConsumers}")
// private Integer concurrentConsumers;
// @Value("${spring.kafka.consumer.group-id}")
// private String groupId;



/*
 * @Bean public ConsumerFactory<String, CustomerDTO> consumerFactory() { Map<String, Object>
 * properties = new HashMap<>(); properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
 * bootstrapServer); properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
 * properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
 * properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "60000");
 * 
 * ErrorHandlingDeserializer<String> headerErrorHandlingDeserializer = new
 * ErrorHandlingDeserializer<>(new StringDeserializer()); ErrorHandlingDeserializer<CustomerDTO>
 * errorHandlingDeserializer = new ErrorHandlingDeserializer<>(new
 * JsonDeserializer<>(CustomerDTO.class, objectMapper())); return new
 * DefaultKafkaConsumerFactory<>(properties, headerErrorHandlingDeserializer,
 * errorHandlingDeserializer); }
 */

// @Bean
// public KafkaListenerContainerFactory<?> kafkaListenerContainerFactory(
// ConsumerFactory<String, CustomerDTO> consumerFactory) {
// ConcurrentKafkaListenerContainerFactory<String, CustomerDTO> kafkaListenerContainerFactory =
// new ConcurrentKafkaListenerContainerFactory<>();
// kafkaListenerContainerFactory.setConcurrency(2);
// kafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
// kafkaListenerContainerFactory.setErrorHandler(new KafkaErrorHandler());
// return kafkaListenerContainerFactory;
// }
//
// private ObjectMapper objectMapper() {
// return Jackson2ObjectMapperBuilder.json()
// .visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
// .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).build();
// }


// }
