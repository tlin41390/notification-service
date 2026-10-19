package com.notification_service.controller;

import com.notification_service.model.Notification;
import com.notification_service.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean; 

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(NotificationController.class)
public class NotificationControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean 
    private NotificationService notificationService;

    @Test 
    void createReturnsCreatedNotification() throws Exception {
        when(notificationService.create(any(), anyString()))
            .thenReturn(new Notification(1L, 42L, "Task created: test"));

        mockMvc.perform(post("/notifications")
                .contentType("application/json")
                .content("{\"taskId\":42,\"message\":\"Task created: test\"}"))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.taskId").value(42));
    }
}
