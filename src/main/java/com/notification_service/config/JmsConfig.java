package com.notification_service.config;

import com.notification_service.messaging.TaskCreatedEvent; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.JacksonJsonMessageConverter; 
import org.springframework.jms.support.converter.MessageConverter; 
import org.springframework.jms.support.converter.MessageType;

import java.util.Map; 

@Configuration
public class JmsConfig {
    
    @Bean 
    public MessageConverter jacksonJmsMessageConverter() {
        JacksonJsonMessageConverter converter = new JacksonJsonMessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        converter.setTypeIdMappings(Map.of("task-created", TaskCreatedEvent.class));
        return converter;
    }
}
