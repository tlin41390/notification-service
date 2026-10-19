package com.notification_service.controller;

import com.notification_service.dto.NotificationRequest;
import com.notification_service.model.Notification; 
import com.notification_service.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/notifications") 
    public ResponseEntity<Notification> create(@RequestBody NotificationRequest request) {
        Notification notification = notificationService.create(request.taskId(), request.message());
        return ResponseEntity.status(HttpStatus.CREATED).body(notification);
    }

    @GetMapping("/notifications") 
    public List<Notification> listAll() {
        return notificationService.listAll();
    }
}
