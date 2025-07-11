package com.grupo5.MSAccessControl.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue visitEventsQueue() {
        return new Queue("visit-events", false);
    }
} 