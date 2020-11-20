package com.prokarma.engineering.customer.consumer.listener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EmbeddedKafka(partitions = 1, topics = {"w3pj8qbv-topic1"})
@SpringBootTest
class CustomerConsumerListenerIntegrationTest {

  private static final String TEST_TOPIC = "w3pj8qbv-topic1";

  @Autowired
  private EmbeddedKafkaBroker embeddedKafkaBroker;

  @Test
  void testReceivingKafkaEvents() {
    Consumer<Integer, String> consumer = configureConsumer();
    Producer<Integer, String> producer = configureProducer();
    producer.send(new ProducerRecord<>(TEST_TOPIC, 123, buildMessageJsonObject()));
    ConsumerRecord<Integer, String> singleRecord =
        KafkaTestUtils.getSingleRecord(consumer, TEST_TOPIC);
    assertNotNull(singleRecord);
    assertEquals(123, singleRecord.key());
    assertEquals(singleRecord.value(), buildMessageJsonObject());
    consumer.close();
    producer.close();
  }

  private Consumer<Integer, String> configureConsumer() {
    Map<String, Object> consumerProps =
        KafkaTestUtils.consumerProps("w3pj8qbv-consumers", "true", embeddedKafkaBroker);
    consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    Consumer<Integer, String> consumer =
        new DefaultKafkaConsumerFactory<Integer, String>(consumerProps).createConsumer();
    consumer.subscribe(Collections.singleton(TEST_TOPIC));
    return consumer;
  }

  private Producer<Integer, String> configureProducer() {
    Map<String, Object> producerProps =
        new HashMap<>(KafkaTestUtils.producerProps(embeddedKafkaBroker));
    return new DefaultKafkaProducerFactory<Integer, String>(producerProps).createProducer();
  }

  public String buildMessageJsonObject() {
    return "{\"customerNumber\":\"C120000022\",\"firstName\":\"James James\",\"lastName\":\"rock star magic\",\"birthDate\":\"11-02-2020\",\"country\":\"India\",\"countryCode\":\"IN\",\"mobileNumber\":\"9083645678\",\"email\":\"abcd@gmail.com\",\"customerStatus\":\"Open\",\"addressLine1\":\"Addr Line 1\",\"addressLine2\":\"Addr 2\",\"street\":\"Mains Street\",\"postalCode\":\"400234\"";
  }


}
