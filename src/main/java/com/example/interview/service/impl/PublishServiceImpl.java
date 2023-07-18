package com.example.interview.service.impl;

import com.example.interview.dto.Customer;
import com.example.interview.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

@Service
public class PublishServiceImpl implements PublishService {
    public static final Logger logger = Logger.getLogger(PublishServiceImpl.class.getName());

    private final KafkaTemplate<String, Customer> kafkaTemplate;

    @Value("${kafka.enabled}")
    String kafkaEnabled;

    @Autowired
    public PublishServiceImpl(KafkaTemplate<String, Customer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(Customer customer) {
        if (!kafkaEnabled.isEmpty() && kafkaEnabled.equals("true")) {
            logger.info("Publishing message to kafka - " + customer.toString());
            try {
                CompletableFuture<SendResult<String, Customer>> future = kafkaTemplate.send("create-customer", customer);
                future.whenComplete((result, ex) -> {
                    if (ex == null) {
                        logger.info("Sent message=[" + customer +
                                "] with offset=[" + result.getRecordMetadata().offset() + "]");
                    } else {
                        logger.info("Unable to send message=[" +
                                customer + "] due to : " + ex.getMessage());
                    }
                });
            } catch (Exception e) {
                logger.severe("Failed to publish to Kafka: " + e.getMessage());
            }
        }
    }
}
