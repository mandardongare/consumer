// package com.prokarma.engineering.customer.consumer.kafka.config;
//
// import org.springframework.boot.context.properties.ConfigurationProperties;
//
// @ConfigurationProperties(prefix = "spring.kafka")
// public class KafkaConsumerProperties {
//
// private String bootstrapServer;
// private String securityProtocol;
// private Topics topics;
// private Integer concurrentConsumers;
// private String groupId;
//
// public String getBootstrapServer() {
// return bootstrapServer;
// }
//
// public void setBootstrapServer(String bootstrapServer) {
// this.bootstrapServer = bootstrapServer;
// }
//
// public String getSecurityProtocol() {
// return securityProtocol;
// }
//
// public void setSecurityProtocol(String securityProtocol) {
// this.securityProtocol = securityProtocol;
// }
//
// public Topics getTopics() {
// return topics;
// }
//
// public void setTopics(Topics topics) {
// this.topics = topics;
// }
//
// public Integer getConcurrentConsumers() {
// return concurrentConsumers;
// }
//
// public void setConcurrentConsumers(Integer concurrentConsumers) {
// this.concurrentConsumers = concurrentConsumers;
// }
//
// public String getGroupId() {
// return groupId;
// }
//
// public void setGroupId(String groupId) {
// this.groupId = groupId;
// }
//
// public static class Topics {
//
// private String create;
//
// public String getCreate() {
// return create;
// }
//
// public void setCreate(String create) {
// this.create = create;
// }
// }
//
// }
