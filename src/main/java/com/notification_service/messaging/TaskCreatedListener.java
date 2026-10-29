package com.notification_service.messaging;

import com.notification_service.service.NotificationService; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component; 

@Component 
public class TaskCreatedListener {
    
    private static final Logger log = LoggerFactory.getLogger(TaskCreatedListener.class);

    private final NotificationService notificationService; 

    public TaskCreatedListener(NotificationService notificationService) { 
        this.notificationService = notificationService;
    }

    @JmsListener(destination = "task.created.queue")
    public void onTaskCreated(TaskCreatedEvent event) {
        notificationService.create(event.taskId(), "Task created: " + event.title());
        log.info("Recorded notification for task {}", event.taskId());
    }
}
