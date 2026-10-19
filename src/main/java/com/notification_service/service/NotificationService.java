package com.notification_service.service;

import com.notification_service.model.Notification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NotificationService {
    private final List<Notification> notifications = new CopyOnWriteArrayList<>();
    private final AtomicLong nextId = new AtomicLong();

    public Notification create(Long taskId, String message) {
        Notification notification = new Notification(nextId.getAndIncrement(), taskId, message);
        notifications.add(notification);
        return notification;
    }

    public List<Notification> listAll() {
        return notifications;
    }
}
