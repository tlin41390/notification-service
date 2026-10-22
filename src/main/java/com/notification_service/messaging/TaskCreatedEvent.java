package com.notification_service.messaging;

public record TaskCreatedEvent(Long taskId, String title) {
    
}
